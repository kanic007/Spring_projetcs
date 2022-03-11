package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.controllers.StudentController;
import com.example.demo.services.StudentService;




@SpringBootTest
@AutoConfigureMockMvc
public class TestStudentcontroller {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private StudentService service;
	
	@InjectMocks
	private StudentController controller;
	
	@Test
	@DisplayName("Test get all students ")
	void testForGetAllStudents() throws Exception {
		mockMvc.perform(get("/students")).andExpect(status().is(200)).andExpect(content().string("Kamala,Vimala"));
	}
	
	
	@Test
	@DisplayName("Test get all students By Id method returns the Kamala for Id 1")
	void testForGetAllStudentById() throws Exception {
		mockMvc.perform(get("/students/1")).andExpect(status().is(200)).andExpect(content().string("Kamala"));
	}
}