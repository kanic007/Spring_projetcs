package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ifaces.CompanyRepository;


@SpringBootApplication
@RestController
@RefreshScope
public class OneToOneCacheConfigClientApplication {
	
	@Value("${custom.message}")
	private String message;
	public static void main(String[] args) {
		SpringApplication.run(OneToOneCacheConfigClientApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner runner() {
		return new CommandLineRunner() {
			@Autowired
			CompanyRepository repo;
			
			@Override
			public void run(String... args)throws Exception{
				System.out.println(repo.findAll());
				System.out.println(message);
			}
		};
	
	}

}
