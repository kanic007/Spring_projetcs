package com.example.demo.repos;

import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository {

	
	String findById(int id);
}
