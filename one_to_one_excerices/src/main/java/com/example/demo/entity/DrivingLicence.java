package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "kanic_licence")
public class DrivingLicence {
	
   
	@Id
	@Column(name = "licence_number")
	private long licenceNumber;
	
	@Column(name = "exp_date")
	private LocalDate expDate;
	
	@Column(name = "rdo_name")
	private String rdoName;
	
}
