package com.example.demo.model.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Customer;
import com.example.demo.model.Invoice;



@Configuration
public class AppConfig {

	
	@Bean
	public Invoice  kanicinvoice(Customer kanic){
		return new Invoice(101,kanic,1999);
	}
	
	@Bean
	public Invoice  selvainvoice( @Qualifier ("hana")  Customer dharashini){
		return new Invoice(102,dharashini,2000);
	}
	
	@Bean
	public Customer kanic() {
		return new Customer(101,"kanic",7550,"kanic@gmail.com");
	}
	
	@Bean
	public Customer selva() {
		return new Customer(102,"selva",7355,"selva@gmail.com");
	}
	
	@Bean
	public Customer hana() {
		return new Customer(103,"hana",7855,"hana@gmail.com");
	}
	
	
	
}
