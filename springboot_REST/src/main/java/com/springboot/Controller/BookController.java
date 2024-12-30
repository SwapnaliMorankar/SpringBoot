package com.springboot.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Entity.Book;
import com.springboot.Service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	private BookService bookservice;

	// Save one book
	@PostMapping("/savebook")
	public ResponseEntity<String> saveOneBook() {
	    Book book1 = new Book();
	    book1.setName("First book");
	    book1.setGenre("Funny");
	    book1.setAuthor("Swapnali");
	    book1.setPageno(300);
	    try {
	        String result = this.bookservice.saveBook(book1);
	        return new ResponseEntity<>(result, HttpStatus.CREATED);
	    } catch (Exception e) {
	        return new ResponseEntity<>("Error saving book", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	// Save multiple books
	@PostMapping("/savebooks")
	public ResponseEntity<String> saveMultipleBooks() {

		Book book2 = new Book();
		book2.setName("Fourth book");
		book2.setGenre("Serious");
		book2.setAuthor("Raj");
		book2.setPageno(400);

		Book book3 = new Book();
		book3.setName("Fifth book");
		book3.setGenre("Romantic");
		book3.setAuthor("Aabha");
		book3.setPageno(200);

		try {
			List<Book> books = List.of(book2, book3);
			String result = this.bookservice.saveBooks(books);
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Error saving book", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Get one book by id
	@GetMapping("/getbook/id/{bookid}")
	public ResponseEntity<Book> getOneBook(@PathVariable("bookid") int id) {

		try {
			Optional<Book> retrivedbook = this.bookservice.getOneBook(id);
			if (retrivedbook.isPresent()) {
				return new ResponseEntity<>(retrivedbook.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Get one book by name
	@GetMapping("/getbook/name/{bookname}")
	public ResponseEntity<Book> getOneBook(@PathVariable("bookname") String name) {

	    try {
	        Book retrievedBook = this.bookservice.getBookByName(name);
	        if (retrievedBook != null) {
	            return new ResponseEntity<>(retrievedBook, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	// Get All books
	@GetMapping("/getbooks")
	public ResponseEntity<Iterable<Book>> getAllBooks() {

	    try {
	        Iterable<Book> retrievedBooks = this.bookservice.getAllBooks();
	        if (retrievedBooks.iterator().hasNext()) {
	            return new ResponseEntity<>(retrievedBooks, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	// Update one book by ID
	@PutMapping("/updatebook/{bookid}")
	public ResponseEntity<String> updateBook(@PathVariable("bookid") int id) {

		try {
			String result = this.bookservice.updateBook(id);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Delete one book by ID
	@DeleteMapping("/deletebook/{bookid}")
	public ResponseEntity<String> deleteBook(@PathVariable("bookid") int id) {

		try {
			String result = this.bookservice.deleteBook(id);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Delete All Books
	@DeleteMapping("/deletebooks")
	public ResponseEntity<String> deleteAllBooks() {

		try {
			String result = this.bookservice.deleteAllBooks();
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
