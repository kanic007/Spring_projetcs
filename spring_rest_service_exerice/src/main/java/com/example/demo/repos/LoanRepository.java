package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.LoanEntity;

public interface LoanRepository extends JpaRepository<LoanEntity, Integer>{

	List<LoanEntity> findByApplicationName(String srchName);
	
	

}
