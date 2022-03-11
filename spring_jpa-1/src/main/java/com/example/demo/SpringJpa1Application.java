package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.entity.Doctor;
import com.example.demo.service.DoctorService;

@SpringBootApplication
public class SpringJpa1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx =SpringApplication.run(SpringJpa1Application.class, args);
		
        
		
          DoctorService service = ctx.getBean(DoctorService.class);
          
          service.findAll().forEach(System.out::println);
          
          
          
          
          
	}

}
