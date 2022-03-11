package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.model.Branch;
import com.example.demo.model.LoanEntity;
import com.example.demo.repos.BranchRepository;


@Service
public class BranchService {

	
	@Autowired
	List<LoanEntity> loanList;
	
	@Autowired
	Branch branch;
	
	@Autowired
	private BranchRepository repo;
	
	
	public Branch updateDetails(Branch entity){
		
		System.out.println("INSIDE SERVICE"+branch);
		return this.repo.save(entity);
	}

	
	
     public List<Branch> findAll(){
		return repo.findAll();
	}




	
	
	
}
