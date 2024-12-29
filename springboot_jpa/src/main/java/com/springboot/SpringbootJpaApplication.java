package com.springboot;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springboot.Dao.UserRepository;
import com.springboot.Entity.User;

@SpringBootApplication
public class SpringbootJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootJpaApplication.class, args);
		System.out.println("Hello");
		UserRepository userRepo = context.getBean(UserRepository.class);
		
		
		//Saving Single User 
		User user = new User();
		user.setName("Arnav");
		user.setNumber(1111);
		user.setCity("Pune");
		User result = userRepo.save(user);
		System.out.println(result);
		
		
		//Save Multiple Users
		User user1 = new User();
		user1.setCity("Nashik");
		user1.setName("Raj");
		user1.setNumber(2222);
		
		User user2 = new User();
		user2.setCity("Sangli");
		user2.setName("Aabha");
		user2.setNumber(3333);
		
		List<User> users = List.of(user1, user2);
		Iterable<User> result2 =  userRepo.saveAll(users);
		result2.forEach(users2->{
			System.out.println(users2);
		});
		
		
		//Update user using ID - gives only that particular id data
		Optional<User> user3 =  userRepo.findById(6);
		System.out.println(user3);
		User user4 = user3.get();
		user4.setName("Aabha");
		userRepo.save(user4);
		System.out.println(user4);

		
		//Get All Data
		Iterable<User> data = userRepo.findAll();
		System.out.println("All users are: ");
		data.forEach(eachdata->{
			System.out.println(eachdata);
		});
		
		
		//Delete one user using ID
		userRepo.deleteById(6);
		System.out.println("User Deleted");		

		
		//Delete All Users
		Iterable<User> allusers = userRepo.findAll();
		userRepo.deleteAll(allusers);
		System.out.println("All Users Deleted");
		
		
		//Custom Finder Methods
		List<User> names = userRepo.findByName("Swapnali");
		if(names.isEmpty()) {
			System.out.println("No Data Found");
		}
		else {
			names.forEach(name->{
				System.out.println(name);
			});
		}
		
		
		//Custom Finder Methods
		List<User> names2 = userRepo.findByNameOrCity("Raj", "Sangli");
		if(names2.isEmpty()) {
			System.out.println("No Data Found");
		}
		else {
			names2.forEach(name1->{
				System.out.println(name1);
			});
		}
		

		//Custom Finder Methods
		List<User> names3 = userRepo.findByNameAndCity("Raj", "Sangli");
		if(names3.isEmpty()) {
			System.out.println("No Data Found");
		}
		else {
			names3.forEach(name1->{
				System.out.println(name1);
			});
		}		
		
	}

}
