package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1")
public class LoanProcessingController {

	@Autowired
	private RestTemplate template;
	
	@GetMapping(path="/loan") 
	public String getCilbilScore(){
		
		return this.template.getForObject("http://CIBIL-SCORE-MICROSERVICE/api/v1/score",String.class);
	}
	
	
}
