package com.example.demo.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.experimental.FieldDefaults;




@AllArgsConstructor

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Doctor {

	//simple values
	int doctorId;
	String doctorName;
	String location;
	
	
// Collobarating Object
	
	
	Patient patient ; 
	
	
	
	
}
