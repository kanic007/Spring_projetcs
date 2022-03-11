package com.example.demo;

import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.Customer;
import com.example.demo.repos.CustomerRepository;
import com.example.demo.service.CustomerService;

@SpringBootApplication
public class JpaOneToManyApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx= SpringApplication.run(JpaOneToManyApplication.class, args);
	
//		CustomerRepository repo = ctx.getBean(CustomerRepository.class);
//		
//	    CustomerService service =ctx.getBean(CustomerService.class);
//	  
//	  
//	    Customer elementToAdd =service.createCustomer();
//	    
////	    Customer added = repo.save(elementToAdd);
////	  
////			  
////		
////		System.out.println("One Row Added"+added);
//	    
//	    
//	    List<Customer> custList = repo.findAll();
//	    
//	    for(Customer cust: custList) {
//	    	
//	    	System.out.println("Customer Name : "+cust.getCustomerName());
//	    	System.out.println("location : "+cust.getLocation());
//	    	System.out.println("Mobile Number : "+cust.getMobileNumber());
//	    	
//	    	
//	    	
//	    	System.out.println("Complaint history");
//	    	
//	    	cust.getCompList().forEach(System.out::println);
//	    }
//	    
//	}
//
//	
//	@Bean
//	public Complaint cm1() {
//		return new Complaint(999,"fridge compressor not working", "comp");
//	}
//	
//	@Bean
//	public Complaint cm2() {
//		return new Complaint(959,"ac not cooling", "pend");
//	}
//	
//	@Bean
//	public Complaint cm3() {
//		return new Complaint(949,"tv singal", "comp");
}
	
	
}
