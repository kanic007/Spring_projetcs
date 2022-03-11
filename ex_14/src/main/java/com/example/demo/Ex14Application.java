package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.model.OrderService;
import com.example.demo.model.SalesOrder;

@SpringBootApplication
public class Ex14Application {

	public static void main(String[] args) {
		 ConfigurableApplicationContext ctx = SpringApplication.run(Ex14Application.class, args);
			
		    OrderService services = ctx.getBean(OrderService.class);
		 
			System.out.println(ctx.getBean("order1",SalesOrder.class));
			System.out.println(services.findTotal());
			
			
	}

}
