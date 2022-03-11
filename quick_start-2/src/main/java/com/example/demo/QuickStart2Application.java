package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.model.College;
import com.example.demo.model.Professor;
import com.example.demo.model.Student;

@SpringBootApplication
public class QuickStart2Application {

	public static void main(String[] args) {
		 ConfigurableApplicationContext ctx = SpringApplication.run(QuickStart2Application.class, args);
			
			System.out.println(ctx.getBean("ramreddy"));
			System.out.println(ctx.getBean("shyamkumar"));
			System.out.println(ctx.getBean("apollo"));
			
			Professor prof = ctx.getBean(Professor.class);
			System.out.println("Excpected : null  +Actual:=" +prof.getStudent());

			College Krishna = ctx.getBean(College.class);
			System.out.println(Krishna.getProf());
			
			
			System.out.println("Student :====="+ctx.getBean("harish",Student.class));
			
			
			
	}

}
