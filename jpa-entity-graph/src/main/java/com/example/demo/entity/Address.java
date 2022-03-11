package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "kanic_address_excella")


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	@Id
	@Column(name = "addressid")
	private int addressId;
	
	@Column(name = "streetname")
	private String streetName;
	
	@Column(name = "nagarname")
	private String nagarName;
	
	
	
	@ManyToOne(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")
	private User user;
	
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "cityid")
	private City city;
	
	
	
	
	
	
}
