package com.example.demo.controller;

import java.nio.file.Path;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Company;
import com.example.demo.services.CompanyService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path ="/api/v1")
public class CompanyController {

	
	private CompanyService service;
	
	@GetMapping(path ="/companies")
	public List<Company> getAll(){
		return this.service.findAll();
	}
	
	@GetMapping(path ="/companies/{id}")
	public Company getById(@PathVariable int id) {
		
		return this.service.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
	}
	
	@PostMapping(path ="/companies")
	public Company add(@RequestBody Company entity) {
		
		return this.service.add(entity);
	}
	
	@PutMapping(path ="/companies")
	public Company update(@RequestBody Company entity) {
		
		return this.service.update(entity);
	}
	
	@DeleteMapping(path ="/companies/{id}")
	public ResponseEntity<String> remove(@PathVariable int id){
		this.service.delete(id);
		
		return ResponseEntity.ok("Record Deleted");
	}
}
