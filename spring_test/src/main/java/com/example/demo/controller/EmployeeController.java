package com.example.demo.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.services.EmployeeService;



@RestController
@RequestMapping(path="api/v1")
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
@GetMapping(path="/employee")
public List<Employee> findAll() {
	return  service.findAll();
}
@PostMapping(path="/employee")
public Employee addEmployee(@RequestBody Employee employee) {
	return this.service.add(employee);
	
}
@PutMapping(path="/employee")
public ResponseEntity<Employee> updateStudent(@RequestBody Employee employee) {	Employee updated=this.service.updateEmployee(employee);
	return ResponseEntity.status(HttpStatus.OK).body(updated);
	
}
@GetMapping(path ="/employee/{id}")
public Optional<Employee> getById(@PathVariable("id") int id) {
	return this.service.findById(id);
			.orElseThrow(()->new IdNotFoundException("Element With "+id+" not present"));
}


@GetMapping(path ="/employee/{designation}")
public Employee getEmployeeById(@PathVariable("designation") String designation) {
	return this.service.findByDesignation(designation);
		.orElseThrow(()->new IdNotFoundException("Element With "+designation+" not present"));
}

@GetMapping(path ="/employee/{salary}")
public Employee getBySalary(@PathVariable("id") int salary) {
	return this.service.findBySalary(salary);
			.orElseThrow(()->new IdNotFoundException("Element With "+id+" not present"));
}



}
