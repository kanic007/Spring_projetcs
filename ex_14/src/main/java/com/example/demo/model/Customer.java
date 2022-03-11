package com.example.demo.model;

import lombok.AccessLevel;

import lombok.Data;
import lombok.experimental.FieldDefaults;

//@AllArgsConstructor

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer {

	 int id;
	 String customerName;
	 String address;
	 
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int id, String customerName, String address) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.address = address;
	}
	
	
}


