package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

	public String getStduent(int id) {
		
		return id==1?"Kamala":"Vimala";
	}

	
	
}
