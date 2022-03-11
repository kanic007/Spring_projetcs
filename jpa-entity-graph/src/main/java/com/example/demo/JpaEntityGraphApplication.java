package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Address;
import com.example.demo.entity.City;
import com.example.demo.entity.User;
import com.example.demo.service.AddressService;

@SpringBootApplication
public class JpaEntityGraphApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx= SpringApplication.run(JpaEntityGraphApplication.class, args);
		
		
		AddressService service =ctx.getBean(AddressService.class);
		
		Address entity = ctx.getBean(Address.class);
		
//		service.add(entity);
//		service.task3(301);
		
//		service.task4(201);
		
		
		
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		service.task5(103);
		
		
		
		
		
		
	}

	@Bean
	public User user() {
		
		return new User(103,"selva");
	}
	
	@Bean
	public City city() {
		
		return new City(201,"coimbatore");
	}
	
	@Bean
	public Address address(City city,User user) {
		
		return new Address(303,"rajiv nagar","indira nagar",user,city);
	}

}
