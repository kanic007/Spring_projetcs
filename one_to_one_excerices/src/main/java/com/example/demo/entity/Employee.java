package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "k_emp")
public class Employee {



@Id
@Column(name="emp_id")
private int empId;

@Column(name="emp_name")
private String empName;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "licence_ref")
DrivingLicence drivingLicence;
	
	
}
