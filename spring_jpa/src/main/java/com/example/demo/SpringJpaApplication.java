package com.example.demo;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.BloodDonor;
import com.example.demo.services.BloodDonorService;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaApplication.class, args);
	BloodDonor donor = ctx.getBean(BloodDonor.class);
		
		BloodDonorService service = ctx.getBean(BloodDonorService.class);
		
		
	//	System.out.println(service.add(donor));
		
//		donor.setDateLastDonated(LocalDate.now());
//		donor.setBloodGroup("Opos");
//		
	//	service.update(donor);
		
		
		//service.delete(donor.getMobileNumber());
		
     //  service.findAll().forEach(System.out::println);
		
    //   service.findByBloodGroup("OPos").forEach(System.out::println);
   
    //   service.findbyFirstName("ramesh").forEach(System.out::println);
       
       
      // service.updateLastDonated(LocalDate.of(2021, 01, 12), 64949);
       service.findAll().forEach(System.out::println);
		}
	
    @Bean
	public BloodDonor donor(){

		return new BloodDonor(949,"ramesh","OPos",LocalDate.of(2021, 01, 12));
		
	}




}
