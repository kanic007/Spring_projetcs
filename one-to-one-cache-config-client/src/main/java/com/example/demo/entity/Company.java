package com.example.demo.entity;

import java.io.Serializable;

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

@Entity
@Table (name="kanic_company_2022")


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Company implements Serializable {

	
	@Id
	@Column(name="companyid")
	private int companyId;
	@Column(name="companyname")
	private String companyName;
	@Column(name="typeofbusiness")
	private String typeOfBusiness;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vendor_ref")
	private Vendor vendor;
}
