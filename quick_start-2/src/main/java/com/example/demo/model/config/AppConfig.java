package com.example.demo.model.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;
import com.example.demo.model.Student;


@Configuration
public class AppConfig {

	// Factory Method with a Bean id same as method name - here it is ram
	
	@Bean(name="ramreddy")
	public  Doctor ram(@Qualifier ("tom") Patient tommy){
		
		return new Doctor(101,"Ram","Chennai",tommy);
	}
	
	// Factory Method with a Bean id same as method name - here it is shyam

	@Bean (name="shyamkumar")// Describe how the obj should be create
	public  Doctor shyam(@Qualifier ("dick") Patient tommy) {
		
		return new Doctor(102,"shyam","porur",tommy);
	}
	
	@Bean 
	public  Patient tom() {
		
		return new Patient(989,"Tom",56);
	}
	
	@Bean
	public  Patient dick() {
		
		return new Patient(990,"dick",66);
	}
	
	@Bean
	public  Patient harry() {
		
		return new Patient(990,"harry",66);
	}
	
	@Bean
	
	public Integer number(){
		
		return Integer.valueOf(100);
	}
	
	
	@Bean
	public Student harish() {
		
		Student stud = new Student();
		
		stud.setId(201);
		stud.setName("Harish");
		
		return stud;
		
	}
	
}
