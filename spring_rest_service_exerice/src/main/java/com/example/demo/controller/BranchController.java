package com.example.demo.controller;


import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Branch;
import com.example.demo.service.BranchService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;



@RestController

@RequestMapping(path="/api/v1")
public class BranchController {

	@Autowired
	private BranchService service;
	
	
	
	@GetMapping(path="/branch")
	@RolesAllowed(value={"ROLE_ADMIN"})
	public List<Branch>findAll(){
		
		return service.findAll();
	}
	
	
	@PostMapping(path="/branch")
	@RolesAllowed(value={"ROLE_ADMIN"})
	public Branch addloan(@RequestBody Branch branch) {
		
		System.out.println("inside controller"+branch);
		 return this.service.updateDetails(branch);
	}
}
