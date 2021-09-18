package com.java.atsea.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.java.atsea.model.Customer;
import com.java.atsea.repositories.CustomerRepository;


@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = CustomerRepository.class)
@ComponentScan("com.java.atsea")
public class EcommerceApplication {

	@Autowired
	CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
		System.out.println("Application started");
	}
	
	
//	@Bean
//	public CommandLineRunner runner(CustomerRepository repository){
//		return args->{
//			Customer customer = new Customer("varma", "tuni","anji@gmail.com","anjaneyavarma","1234");
//
//			repository.insert(customer);
//			System.out.println("Application started - 1");
//
//		};
//
//	}
}
