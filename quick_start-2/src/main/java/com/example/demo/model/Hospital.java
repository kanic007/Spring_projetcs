package com.example.demo.model;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.ToString;



@ToString
@Component ("apollo")// to register as bean can also be done using a method with @Bean annotation
public class Hospital {

	List<Patient> patientList;
	
	
	@Autowired // Injecting the List of Patients into the Constructor
	public Hospital(List<Patient> patientList) {
		super();
		this.patientList=patientList;
	}
	
	
                                                          
	
}
                                                                                    