package com.example.demo.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="kanic_employee")
public class Employee {
	
	@Id
	@Column(name="e_id")
	private int empId;
	
	@Column(name="name")
	private String empName;
	
	@Column(name="Fathers_name")
	private String fatherName;
	
	@Column(name="contact_number")
	private long contactNum;
	
	@Column(name="Address")
	private String address;
	
	
	@Column(name="location")
	private String location;

	@Column(name="salary")
	private int salary;
	
	@Column(name="dob")
	private LocalDate dob;
	
	@Column(name="doj")
	private LocalDate doj;
	
	@Column(name="createddate")
	private LocalDate createdDate;
	
	@Column(name="createdby")
	private String createdBy;
	
	@Column(name="modifieddate")
	private LocalDate modifiedDate;
	
	@Column(name="modifiedby")
	private String modifiedBy;
	
	@OneToMany(targetEntity = Designation.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_ref", referencedColumnName = "e_id")
	List<Designation> desgList;
	
	
	

}
