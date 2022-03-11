package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BloodDonor;
import com.example.demo.repos.BloodDonorRepository;

@Service
public class BloodDonorService {

	private BloodDonorRepository repo;
	
	
@Autowired
	public BloodDonorService(BloodDonorRepository repo) {
		super();
		this.repo = repo;
		
		System.out.println(	this.repo.getClass().getName());
	}
	
	public BloodDonor add(BloodDonor donor) {
		return this.repo.save(donor);
	}
	
	public List<BloodDonor> findAll(){
		return this.repo.findAll();
	}
	
	
	
	public void delete(long id) {
		this.repo.deleteById(id);
	}
	
	
	
	public BloodDonor update(BloodDonor donor) {
		
		return this.repo.save(donor);
	}
	
	public List<BloodDonor> findByBloodGroup(String group){
		return this.repo.findByBloodGroup(group);
	}
	
	public List<BloodDonor> findbyFirstName(String srchName){
		return this.repo.findByFirstName(srchName);
	}
	
	public List<BloodDonor> findbyGroupAndLastDonatedDated(String group, LocalDate date){
		return this.repo.srchByGroupAndDate(group,date);
		
		}
	
	public int updateLastDonated(LocalDate date, long mobileNumber){
		return this.repo.updateLastDonated(date, mobileNumber);
		 
	}
	
	
}
