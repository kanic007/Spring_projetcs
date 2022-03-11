package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Company;
import com.example.demo.entity.Vendor;
import com.example.demo.ifaces.CompanyRepository;
import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;

@SpringBootApplication
@EnableCaching
@EnableDiscoveryClient
public class OneToOneWithCachingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneToOneWithCachingApplication.class, args);
	}
	
	@Bean
	public Config hazelConfig() {
		
		return new Config()
				.addMapConfig(new MapConfig().setName("compcache"));
				
	}
	
	@Bean
	public CommandLineRunner runner() {
		return new CommandLineRunner() {
			
			@Autowired
			private CompanyRepository repo;
			@Override
			public void run(String... args) throws Exception {
		             Vendor vendor = new Vendor(1020,"ravi travels","kknagr","transport");
				     Company abc = new Company(488348,"ABC corporation","software",vendor);
				     
				     this.repo.save(abc);
			}
		};
		
	}

}
