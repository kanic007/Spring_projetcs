package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Company;


@RestController
@RequestMapping("/api/v1")
public class OneToOneController {

	
	@Autowired
	private RestTemplate template;
	
	@GetMapping(path="/companies") 
	public Company[] getEmployee(){
		
		return this.template.getForObject("http://ONE-TO-ONE-WITH-CHACHING/api/v1/companies",Company[].class);
	}
	
	@PostMapping(path="/companies") 
	public Company addEmployee(@RequestBody Company entity ){
		HttpEntity<Company> ent = new HttpEntity<>(entity);
		
		return this.template.postForObject("http://ONE-TO-ONE-WITH-CHACHING/api/v1/companies",ent,Company.class);
	}
	
	
}
