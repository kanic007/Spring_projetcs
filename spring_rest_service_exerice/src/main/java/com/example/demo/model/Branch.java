package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="kanic_branch")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Branch {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="seq")
	//@SequenceGenerator(name="seq",sequenceName = "kanic_seqc" ,allocationSize = 1)
	
	
	@Column(name="branchcode")
	private int branchCode;
	
	@Column(name="branchmanger")
	private String branchManger;
	

	@OneToMany(targetEntity = LoanEntity.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "branch_ref",referencedColumnName = "branchcode")
	private List<LoanEntity> loanList;
	
}
