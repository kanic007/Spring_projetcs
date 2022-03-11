package org.training.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.demo.model.Student;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

//@AllArgsConstructor

@Data
@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Professor {

	int id;
	String name;
	
	@Autowired
	//@Qualifier ("ram")
	Student student1;
	
}
