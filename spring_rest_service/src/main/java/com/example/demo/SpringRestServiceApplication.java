package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.model.Student;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info (title = "Student Service" , version ="1.0"))
public class SpringRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestServiceApplication.class, args);
	}

	@Bean
	public Student ram() {
		return new Student(101,"Ramesh",99);
		
	}
	
	@Bean
	public Student kanic() {
		return new  Student(102,"kanic",98);
	 
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	
	
}
