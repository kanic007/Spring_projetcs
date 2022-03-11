package com.example.demo.repos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
  
	@Query(value="update kanic_Student set markscored=:updatedMark where roll_Number=:number"
			,nativeQuery = true)
	@Modifying
	@Transactional
	public int updateMark(@Param("number") int rollNumber 
			             ,@Param("updatedMark") double  updatedMark);
	
	
	
	}
