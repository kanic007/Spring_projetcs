package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;




@Entity
@Table(name = "kanic_student")
@Data
public class Student {

	@Id
	@Column(name = "roll_number")
	private int rollNumber;
	@Column(name = "student_name")
	private String studentName;
	
}
