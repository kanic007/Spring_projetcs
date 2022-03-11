package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;

import com.example.demo.model.Student;

import excella.project.asssignment.College;

import org.training.model.*;
@SpringBootApplication
@ComponentScan(basePackages = {"org.training.model","com.example.demo.model"})
public class QuickStartApplication {

	public static void main(String[] args) {
		 ConfigurableApplicationContext ctx = SpringApplication.run(QuickStartApplication.class, args);
			
		//	System.out.println("Student :="+ctx.getBean(Student.class));
			//System.out.println("Student :="+ctx.getBean("ram"));
			System.out.println("Student :="+ctx.getBean("jaya"));
			System.out.println(ctx.getBean("jaya",Professor.class));
			System.out.println(ctx.getBean("professor",Professor.class));
			System.out.println(ctx.getBean("tom",College.class));
	
	}
	
	
	@Bean
	
	public Student ram() {
		
		Student ram = new Student();
		
		ram.setId(2020);
		ram.setFirstName("RamKumar");
				
		return ram;
	}
	
@Bean
@Primary
public Student yam() {
		
		Student ram = new Student();
		
		ram.setId(2020);
		ram.setFirstName("yam");
				
		return ram;
	}

	
	@Bean
	@Primary	
	public Professor jaya() {
		
		Professor prof = new Professor();
		
		prof.setId(30410);
		prof.setName("jayanthi");
		
		
		prof.setStudent1(yam());
				
		return prof;
	}
	
	@Bean
	public College tom() {
		
		College prof1 = new College();
		prof1.setProf(jaya());
		return prof1;
	}
	
	
}
