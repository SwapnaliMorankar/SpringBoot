package com.springboot.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Entity.Author;
import com.springboot.Entity.Book;
import com.springboot.Service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	private BookService bookService;

	// To Save a Book
	@PostMapping("/savebook")
	public ResponseEntity<String> saveBook(@RequestBody Book book) {
		try {
			String savedBook = this.bookService.saveBook(book);
			return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// To Get Book by ID
	@GetMapping("/getbook/{bookid}")
	public ResponseEntity<Optional<Book>> getAuthor(@PathVariable("bookid") int id) {

		try {
			Optional<Book> book = this.bookService.getBook(id);
			if (book.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(book, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
