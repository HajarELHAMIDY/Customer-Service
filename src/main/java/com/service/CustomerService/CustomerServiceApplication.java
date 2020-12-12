package com.service.CustomerService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.service.CustomerService.entities.Customer;
import com.service.CustomerService.repositories.CustomerRepository;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	
    @Bean
	CommandLineRunner start(CustomerRepository customerrepository, RepositoryRestConfiguration restconfg) {
    	restconfg.exposeIdsFor(Customer.class); 
		return args ->{
			customerrepository.save(new Customer(null,"hajar", "hajar@gmail.com")); 
			customerrepository.save(new Customer(null,"test1", "test1@gmail.com")); 
			customerrepository.save(new Customer(null,"test2", "test1@gmail.com")); 
			customerrepository.findAll().forEach(c->{
				System.out.println(c.getName()+" -> "+c.getEmail());
			});
		}; 
	}

}
