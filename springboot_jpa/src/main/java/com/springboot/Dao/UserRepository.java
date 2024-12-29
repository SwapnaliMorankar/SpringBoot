package com.springboot.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springboot.Entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	public List<User> findByName(String name);
	public List<User> findByNameOrCity(String name, String city);
	public List<User> findByNameAndCity(String name, String city);

}
