package com.springboot.Dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.Entity.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer>{

}
