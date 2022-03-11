package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConfigClientApplication {
	
	@Value("${custom.message}")
	private String message;
	
    public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}
    
    
    @GetMapping(path = "/message")
    public String getMessage() {
    	return this.message;
    }

}
