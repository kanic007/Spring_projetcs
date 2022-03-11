package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="kanic_complaint_2022")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Complaint {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name ="id")
	private int id;
	
	@Column(name ="description")
    private String description;
	
	@Column(name ="status")
	private String status;

	public Complaint( String description, String status) {
		super();
		
		this.description = description;
		this.status = status;
	}
	

}
