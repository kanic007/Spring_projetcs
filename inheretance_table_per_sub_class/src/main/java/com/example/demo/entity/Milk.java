package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name="kanic_milk2")
@PrimaryKeyJoinColumn(name="product_ref")

public class Milk extends Product{
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "sheflife")
	private String shefLife;

	public Milk(int productId, String productName, double ratePerUnit, String type, String shefLife) {
		super(productId, productName, ratePerUnit);
		this.type = type;
		this.shefLife = shefLife;
	}
	
	
	
	
}
