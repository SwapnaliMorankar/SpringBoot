package com.springboot.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springboot.Entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	
	public List<Student> findByFname(String fname);
	public List<Student> findByLname(String lname);
	public List<Student> findByFnameAndLname(String fname, String lname);
	public List<Student> findByFnameOrLname(String fname, String lname);
	public List<Student> findByFnameStartingWith(String prefix);
	public List<Student> findByLnameStartingWith(String prefix);
	public List<Student> findByFnameEndingWith(String suffix);
	public List<Student> findByCityContaining(String words);
	public List<Student> findByAgeLessThan(int age);
}
