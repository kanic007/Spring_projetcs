package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repos.EmployeeRepository;



@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repo;

	public Employee add(Employee entity) {
		return this.repo.save(entity);
	}
	
	public List<Employee> findAll() {
		return this.repo.findAll();
	}
	
	public Employee updateEmployee(Employee entity){
		return this.repo.save(entity);
	}

	public Optional<Employee> findById(int id) {
		return this.repo.findById(id);
	}
	public Employee findByDesignation(String designation) {
		return this.repo.findByDesignation(designation);	}

	public Employee findBySalary(int salary) {
		return this.repo.findBySalary(salary);
	}
}