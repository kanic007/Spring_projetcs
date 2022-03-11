package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "kanic_city_excella")


@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {

	
	@Id
	@Column(name = "cityid")
	private int cityId;
	
	@Column(name = "cityname")
	private String cityName;
}
