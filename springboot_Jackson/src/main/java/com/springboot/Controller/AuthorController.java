package com.springboot.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Entity.Author;
import com.springboot.Service.AuthorService;

@RestController
@RequestMapping("/api")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	// To Get Author by ID
	@GetMapping("/getauthor/{authorid}")
	public ResponseEntity<Optional<Author>> getAuthor(@PathVariable("authorid") int id){
		
		try {
			Optional<Author> author = this.authorService.getAuthor(id);
			if(author.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(author, HttpStatus.OK);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
