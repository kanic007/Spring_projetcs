package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.example.demo.repos.StudentRepository;


@Service
@Lazy
public class AnthoerStudentService {

	
	@Autowired
	StudentRepository repo;

	public String getStudent(int id) {
		return this.repo.findById(id).toUpperCase();
		
	}
	
}
