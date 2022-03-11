package com.example.demo.resource;

import java.io.File;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/rest")
public class StudentImageResource {

	@GET
	@Path("/image")
	@Produces("image/jpeg")
	public File getImageResenation() {
		
		return new File("e://nature.jpg");
	}
	
	
	@GET
	@Path("/students/details")
	@Produces(MediaType.APPLICATION_JSON)
	public String getStudentsDetails(){
		
	     JsonObject map =  Json.createObjectBuilder()
	    		 .add("name","ram")
	    		 .add("mark",40)
	    		 .build();
	     
         return map.toString();

	}
	
}
