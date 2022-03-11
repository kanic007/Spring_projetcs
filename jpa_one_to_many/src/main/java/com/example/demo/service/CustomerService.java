package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.Customer;
import com.example.demo.repos.CustomerRepository;

@Service
public class CustomerService {

	
	@Autowired
	List<Complaint> complainList;
	
	@Autowired
	Customer customer;
	
	@Autowired
	private CustomerRepository repo;
	
	
	public Customer createCustomer() {
		
		
		customer.setId(999);
		
		customer.setCustomerName("arun");
		customer.setLocation("chennai");
		customer.setMobileNumber(787557899);
		customer.setCompList(complainList);
		
		return customer;
	}
	
	
     public List<Customer> findAll(){
		
		return repo.findAll();
	}
	
	
	
}
