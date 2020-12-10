package com.example.accessingdatamongodb;


import com.example.accessingdatamongodb.Entity.User;
import com.example.accessingdatamongodb.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AccessingDataMongodbApplication implements CommandLineRunner {

	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataMongodbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		repository.deleteAll();
//
//		// save a couple of customers
//		repository.save(new User("Alice",1000,100));
//		repository.save(new User("Bob", 2000,200));

//		// fetch all customers
//		System.out.println("Customers found with findAll():");
//		System.out.println("-------------------------------");
//		for (User user : repository.findAll()) {
//			System.out.println(user);
//		}
//		System.out.println();
//
//		// fetch an individual customer
//		System.out.println("Customer found with findByFirstName('Alice'):");
//		System.out.println("--------------------------------");
//		System.out.println(repository.findByName("Alice"));


	}

}