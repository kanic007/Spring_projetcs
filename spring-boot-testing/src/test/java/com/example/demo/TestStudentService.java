package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.services.StudentService;

@SpringBootTest


public class TestStudentService {

	
	@Autowired
	StudentService service;
	
	@Test
	void testgetStudent() {
		
		String actual = service.getStduent(1);
		String expected ="Kamala";
		
		Assertions.assertEquals(actual,expected);
		
	}
	
	
	
}
