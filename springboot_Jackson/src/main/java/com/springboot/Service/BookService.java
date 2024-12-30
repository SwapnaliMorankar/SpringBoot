package com.springboot.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.Dao.BookRepository;
import com.springboot.Entity.Book;

@Component
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	public String saveBook(Book book) {
		this.bookRepo.save(book);
		return "Book Saved Successfully";
	}

	public Optional<Book> getBook(int id){
		Optional<Book> book = this.bookRepo.findById(id);
		return book;
	}

}
