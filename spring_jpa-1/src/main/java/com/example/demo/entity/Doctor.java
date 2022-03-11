package com.example.demo.entity;



import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)


@Entity
@Table(name = "kanic_doctor")


public class Doctor {

	
	@Id
	@Column(name="doctorid")
    int doctorId;
	
	@Column(name="doctorname")
	String doctorName;
	
	@Column(name="handphone")
	String handPhone;
	
	@Column(name="email")
	String  email;	
	
	@Column(name="specialization")
	String specialization;
	
	@Column(name="city")
	String  city;	
	
}
