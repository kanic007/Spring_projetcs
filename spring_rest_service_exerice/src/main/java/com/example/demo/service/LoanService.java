package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.model.LoanEntity;

import com.example.demo.repos.LoanRepository;

@Service
public class LoanService {

	@Autowired
	private LoanRepository repo;
	
	public LoanEntity add(LoanEntity entity){
		return this.repo.save(entity);
		
	}
	
	public List<LoanEntity> findAll() {
		return this.repo.findAll();
	}
	
	public LoanEntity update(LoanEntity entity){
		return this.repo.save(entity);
		
	}
	
	
	public Optional<LoanEntity> findById(int id){
		
		return this.repo.findById(id);
   }
	
	public Optional<LoanEntity> remove(LoanEntity entity){
		
		Optional<LoanEntity> value = Optional.empty();
		
		if(this.repo.existsById(entity.getApplicatioNumber())) {
			this.repo.delete(entity);
			
			value =Optional.of(entity);
		} 
		return value;
	}
	
	public LoanEntity updateDetails(LoanEntity entity){
		return this.repo.save(entity);
	}

	
	public Optional<Object> removeById(int id){
		
		Optional<Object> value = Optional.empty();
		
		if(this.repo.existsById(id)) {
			this.repo.deleteById(id);
			
			value =Optional.of(id);
		} 
		return value;
	}

	
	public List<LoanEntity> findByApplicationName(String srchName){
		return this.repo.findByApplicationName(srchName);
	}


	
	
}
