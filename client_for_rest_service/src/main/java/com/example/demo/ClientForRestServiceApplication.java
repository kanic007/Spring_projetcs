package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Student;

@SpringBootApplication
public class ClientForRestServiceApplication {

	public static void main(String[] args) {
	 ConfigurableApplicationContext ctx =SpringApplication.run(ClientForRestServiceApplication.class, args);
	  
	   RestTemplate template = ctx.getBean(RestTemplate.class);
	   
	   HttpEntity<HttpHeaders> entity = ctx.getBean(HttpEntity.class);
	   
	   
	   ResponseEntity<String> response =
			   template.exchange("http://localhost:8099/api/v1/students",HttpMethod.GET,entity, String.class);
	   
	   System.out.println("Response From REST API :="+response);
	   
//	   String ram ="{'rollNumber': 107, 'studentName': 'selva,  'markscored': 78}";
	   
//	   Student ram = new Student (956,"kumar",77);
//	   HttpEntity<Student> data = new HttpEntity<Student>(ram);
//	   
//	   ResponseEntity<Student> response =
//			   template.postForEntity("http://localhost:8099/api/v1/students", data, Student.class);
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		
//		Map<String,Object> map = new HashMap<>();
//		map.put("rollNumber", 111);
//		map.put("studentName", "Dharshini");
//		map.put("markscored", 76);
//		
//		HttpEntity<Map<String,Object>> entity = new HttpEntity<>(map,headers);
//	   
//	   ResponseEntity<String> response =
//			   template.postForEntity("http://localhost:8099/api/v1/students", entity, String.class);
//	
//	   System.out.println(response.getBody());
//	   System.out.println("Status Code:="+ response.getStatusCodeValue());
//	   System.out.println("Location:="+ response.getHeaders().get("location"));
//	   
	   
	   
//	   
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		
//		Map<String,Object> map = new HashMap<>();
//		map.put("rollNumber", 111);
//		map.put("studentName", "Dharshini");
//		map.put("markscored", 100);
//		
//		HttpEntity<Map<String,Object>> entity = new HttpEntity<>(map,headers);
//	   
////	   ResponseEntity<String> response =
////			   template.exchange("http://localhost:8099/api/v1/students",HttpMethod.PUT, entity, String.class);	
//
//	   ResponseEntity<String> response =
//			   template.exchange("http://localhost:8099/api/v1/students",HttpMethod.POST, entity, String.class);	
//
//	   
//	   System.out.println(response.getBody());
//	   System.out.println("Status Code:="+ response.getStatusCodeValue());
//       System.out.println("Location:="+ response.getHeaders().get("location"));
	}
	
	
	
	@Bean
	public HttpHeaders header(){
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		return headers;
		
	}
	
	@Bean
	public RestTemplate template(BasicAuthenticationInterceptor interceptor){
		
		RestTemplate template= new RestTemplate();
		template.getInterceptors().add(interceptor);
		return template;
	
	}
	
	@Bean
	public HttpEntity<HttpHeaders> entity(HttpHeaders header){
		HttpEntity<HttpHeaders> entity = new HttpEntity<HttpHeaders>(header);
		return entity;
		
	}
	
	
	@Bean
	public BasicAuthenticationInterceptor interceptor(){
		return new BasicAuthenticationInterceptor("guest","guest");
	}
	
	

}
