package com.example.demo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.model.Branch;
import com.example.demo.model.LoanEntity;
import com.example.demo.repos.BranchRepository;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import java.util.*;
@SpringBootApplication
@OpenAPIDefinition(info = @Info (title = "Student Service" , version ="1.0"))
public class SpringRestServiceExericeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestServiceExericeApplication.class, args);
	}

	
	@Bean
	public BCryptPasswordEncoder encoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public CommandLineRunner runner() {
		
		
		return new CommandLineRunner() {
			
			@Autowired
			BranchRepository repo;
			
			@Override
			public void run(String... args) throws Exception {
				// TODO Auto-generated method stub
				
				LoanEntity loan = new LoanEntity(526, "kanic", LocalDate.now(), 5000, "GL");
				
				List<LoanEntity> list = new ArrayList<>();
				list.add(loan);				
				Branch branch = new Branch(101, "selva",list );
						this.repo.save(branch);
						
				
			}
		};
	}
}
