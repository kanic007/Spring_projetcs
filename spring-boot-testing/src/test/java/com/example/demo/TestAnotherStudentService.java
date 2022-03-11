package com.example.demo;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.example.demo.repos.StudentRepository;
import com.example.demo.services.AnthoerStudentService;


@SpringBootTest
@AutoConfigureMockMvc
public class TestAnotherStudentService {

	@Autowired
	AnthoerStudentService service;
	
	@MockBean
	private StudentRepository repo;
	
	String stud1= "kamala";
	
	@Test
	@DisplayName("Test get  student ")
	void testForGetStudents() throws Exception {
		
		BDDMockito.given(repo.findById(1)).willReturn(stud1);
		
		Assertions.assertEquals("KAMALA",service.getStudent(1));
		
		
	}
}
