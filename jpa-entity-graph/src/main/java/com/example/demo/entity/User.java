package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "kanic_users_excella")


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	@Column(name = "userid")
	private int userId;
	
	@Column(name = "username")
	private String userName;

}



