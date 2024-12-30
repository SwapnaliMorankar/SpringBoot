package com.springboot.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.Dao.BookRepository;
import com.springboot.Entity.Book;

@Component
public class BookService {
	
	@Autowired
	private BookRepository bookrepo;
	
	//save one book
	public String saveBook(Book book) {
		this.bookrepo.save(book);
		return "Book Saved Successfully";
	}
	
	//save multiple books
	public String saveBooks(List<Book> books) {
		this.bookrepo.saveAll(books);
		return "Books Saved Successfully";
	}
	
	//Get one book by ID
	public Optional<Book> getOneBook(int id) {
		Optional<Book> b1 = this.bookrepo.findById(id);
		return b1;
	}
	
	//Get All Books
	public Iterable<Book> getAllBooks() {
		Iterable<Book> b2 = this.bookrepo.findAll();
		return b2;
	}
	
	//Get one book by Name
	public Book getBookByName(String name) {
		Book books = this.bookrepo.findByName(name);
		return books;
	}
	
	//Update an Book by ID
	public String updateBook(int id) {
		Optional<Book> b3 = this.bookrepo.findById(id);
		Book b = b3.get();
		b.setName("New Book");
		this.bookrepo.save(b);
		return "Book Updated Successfully /n Updated Book: " + b;
	}
	
	//Delete A book by ID
	public String deleteBook(int id) {
		this.bookrepo.deleteById(id);
		return "Book Deleted Successfully";
	}
	
	//Delete All Books
	public String deleteAllBooks() {
		this.bookrepo.deleteAll();
		return "All Books Deleted Successfully";
	}

}
