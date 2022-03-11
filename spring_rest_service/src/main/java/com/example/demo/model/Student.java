package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor     


@Entity
@Table(name="kanic_Student")
public class Student {

	@Id
	@Column(name="rollNumber")
	private int rollNumber;
	
	@Column(name="studentName")
	private String studentName;
	
	
	@Column(name="markscored")
	@Range(min =0,max=100,message="Mark scored By the satudent")
	@Schema(defaultValue="0",
	         description = "Mark scored By the Student", example="0 to 100")
	private double markscored;
	
	
}
