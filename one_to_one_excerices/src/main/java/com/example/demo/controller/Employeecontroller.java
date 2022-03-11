package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.services.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path="api/v1")

public class Employeecontroller {

	private EmployeeService service;
	
	@GetMapping(path ="/employees")
	public List<Employee> findAll(){
		return service.findAll();
	}
	
	@PostMapping(path="/employees")
	public Employee add(@RequestBody Employee employee) {
		return service.add(employee);
	}
}
