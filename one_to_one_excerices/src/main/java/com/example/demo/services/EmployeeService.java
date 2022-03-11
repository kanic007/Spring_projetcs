package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.ifaces.EmployeeRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class EmployeeService {

	private EmployeeRepository repo;
	
	
	public List<Employee> findAll(){
		return this.repo.findAll();
	}
	
	
	public Employee add(Employee entity) {
		return this.repo.save(entity); 
	}
	
	
	
	
}
