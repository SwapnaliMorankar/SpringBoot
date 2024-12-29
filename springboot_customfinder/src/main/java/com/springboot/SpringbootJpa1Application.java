package com.springboot;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.springboot.Dao.StudentRepository;
import com.springboot.Entity.Student;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootJpa1Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootJpa1Application.class, args);
		StudentRepository studentRepo = context.getBean(StudentRepository.class);


		//Custom Finder Methods
		List<Student> names = studentRepo.findByFname("Swapnali");
		if(names.isEmpty()) {
			System.out.println("No Data Found");
		}
		else {
			names.forEach(name->{
				System.out.println(name);
			});
		}
		
		List<Student> names1 = studentRepo.findByLname("More");
		if(names1.isEmpty()) {
			System.out.println("No Data Found");
		}
		else {
			names1.forEach(name->{
				System.out.println(name);
			});
		}
		
		List<Student> names2 = studentRepo.findByAgeLessThan(23);
		if(names2.isEmpty()) {
			System.out.println("No Data Found");
		}
		else {
			names2.forEach(name->{
				System.out.println(name);
			});
		}
		
		List<Student> names3 = studentRepo.findByFnameAndLname("Swapnali", "Shinde");
		if(names3.isEmpty()) {
			System.out.println("No Data Found");
		}
		else {
			names3.forEach(name->{
				System.out.println(name);
			});
		}
		
		List<Student> names4 = studentRepo.findByFnameOrLname("Swapnali", "More");
		if(names4.isEmpty()) {
			System.out.println("No Data Found");
		}
		else {
			names4.forEach(name->{
				System.out.println(name);
			});
		}
		
		List<Student> names5 = studentRepo.findByFnameStartingWith("Swap");
		if(names5.isEmpty()) {
			System.out.println("No Data Found");
		}
		else {
			names5.forEach(name->{
				System.out.println(name);
			});
		}
		
		List<Student> names6 = studentRepo.findByLnameStartingWith("Shinde");
		if(names6.isEmpty()) {
			System.out.println("No Data Found");
		}
		else {
			names6.forEach(name->{
				System.out.println(name);
			});
		}
		
		List<Student> names7 = studentRepo.findByFnameEndingWith("li");
		if(names7.isEmpty()) {
			System.out.println("No Data Found");
		}
		else {
			names7.forEach(name->{
				System.out.println(name);
			});
		}
		
		List<Student> names8 = studentRepo.findByCityContaining("an");
		if(names8.isEmpty()) {
			System.out.println("No Data Found");
		}
		else {
			names8.forEach(name->{
				System.out.println(name);
			});
		}	
		
		
		//JPQL Custom Defined Query
		List<Student> students = studentRepo.getAllUsers();
		students.forEach(student->{
			System.out.println(student);
		});
		
		
		List<Student> students1 = studentRepo.getStudentByName("Swapnali");
		System.out.println(students1);
		
	}

}
