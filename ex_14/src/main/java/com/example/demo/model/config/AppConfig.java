package com.example.demo.model.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Customer;
import com.example.demo.model.Item;

import com.example.demo.model.SalesOrder;


@Configuration
public class AppConfig {

	// Factory Method with a Bean id same as method name - here it is ram
	
	@Bean
	public  SalesOrder order1(Customer kanic ,List<Item> tv ){
		
		return new SalesOrder(101,LocalDate.now(),kanic ,tv);
		
//		SalesOrder order = new SalesOrder();
//		order.setOrderId(101);
//		order.setCreatedDate(LocalDate.now());
//		order.setCustomer(kanic);
//		order.setItemList(tv);
//		return order;
	}
	@Bean
	public Integer id() {
		return 1;
	}
	
	@Bean
	public LocalDate date() {
		return LocalDate.now();
	}
	
	
	
	
	

	@Bean
	public  Customer kanic( ){
		
		return new Customer(201,"kanic","chennai");
	}
	

	@Bean
	public Item tv(){
		
		return new Item(101,"sony",1.0,25.02);
	}

	
	
}
