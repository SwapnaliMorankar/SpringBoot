package com.springboot.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.Dao.AuthorRepository;
import com.springboot.Entity.Author;

@Component
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepo;
	
	public Optional<Author> getAuthor(int id) {
		Optional<Author> a1 = this.authorRepo.findById(id);
		return a1;
	}

}
