package com.example.demo.controller;

import java.net.URI;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.LoanEntity;

import com.example.demo.service.LoanService;


@RestController
//@RequestMapping(path="/api/v1")
public class LoanController {

	@Autowired
	private LoanService service;
	
//	@PostMapping(path="/Loan")
//	public ResponseEntity<LoanEntity> addStudent(@RequestBody LoanEntity loan) {
//		
//		URI uri=ServletUriComponentsBuilder
//				.fromCurrentRequest()
//				.path("/id")
//				.buildAndExpand(loan.getApplicationumber())
//				.toUri();
//		
//		
//		LoanEntity addedEnity = this.service.add(loan);
//		
//		      return ResponseEntity.created(uri).body(addedEnity);
//		         
//	}
	
	@PostMapping(path="/loans")
	@RolesAllowed(value={"ROLE_ADMIN"})
	public LoanEntity addLoan(@RequestBody LoanEntity loan){
		
		      return this.service.add(loan);
		         
	}
	
	@GetMapping(path="/example/loans")
	//@RolesAllowed(value={"ROLE_ADMIN","ROLE_GUEST"})
	@PermitAll
	public List<LoanEntity> findAll(Principal principal) {
		
		
		System.out.println(principal.getName());
		return this.service.findAll();
	}
	
	@PutMapping(path="/loans")
	public LoanEntity updateLoan(@RequestBody LoanEntity loan){
		
		      return this.service.update(loan);
	}
	
	@GetMapping(path="/loans/{id}")
	public LoanEntity getLoanById(@PathVariable("id") int applicationNumber){
		 
		return this.service.findById(applicationNumber).orElseThrow(() -> new IdNotFoundException("Element with"+ applicationNumber+" NotFound"));
	}
	
	
	@DeleteMapping(path="/loans")
	public ResponseEntity<LoanEntity> removeStudent(@RequestBody LoanEntity entity){
		LoanEntity deleted = this.service.remove(entity)
				.orElseThrow(()-> new RuntimeException("Element with"+ entity.getApplicatioNumber()+" NotFound "));
		
		return ResponseEntity.status(200).body(deleted);
				
	}
	
	@DeleteMapping(path="/loans/delete/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void removeByApplication(@PathVariable("id") int id){
	
		this.service.removeById(id)
		       .orElseThrow(() -> new RuntimeException("Element with "+ id +"Not Present"));
				
	}
	
	
	@RequestMapping(value = "/loans/{findByApplicationName}")
	public String getFindByApplicationName(@RequestParam("findByName") String firstName,Model model) {
		
		List<LoanEntity> list1=this.service.findByApplicationName(firstName);
		model.addAttribute("list",list1);
		return "showAll";
	}
	
	
	
	
	
	
}
