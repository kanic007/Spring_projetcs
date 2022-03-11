package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository<Employee> extends JpaRepository<Employee, Integer> {

	Employee findByDesignation(String designation);
	@Query(value="select * from sd_test_emp where salary=:udatedSalary",nativeQuery = true)
	public Employee findBySalary(@Param("udatedSalary") int salary);
}



