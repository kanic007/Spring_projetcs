package com.example.demo.controller;

import java.security.Principal;

import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v2")
public class TeacherController {

	
	@GetMapping(path ="/teachers")
	public String  getMessage(Principal pricipal) {
		
		System.out.println("Current User:="+ pricipal );
		return "Hello from Teachers Controller";
	}
}
