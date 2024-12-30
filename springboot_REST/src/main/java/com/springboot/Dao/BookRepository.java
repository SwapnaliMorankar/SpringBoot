package com.springboot.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springboot.Entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{
	
	public Book findByName(String name);

}
