package com.springboot.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

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
	
	//JPQL and Native Custom defined Queries
	@Query("select s FROM Student s")
	public List<Student> getAllUsers();
	
	@Query("select s FROM Student s WHERE s.fname =:n")
	public List<Student> getStudentByName(@Param("n") String fname);
	
}
