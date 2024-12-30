package com.springboot.Dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.Entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

}
