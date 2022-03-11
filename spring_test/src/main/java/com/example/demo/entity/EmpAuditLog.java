package com.example.demo.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="kanic_emp_auditlog")
public class EmpAuditLog {


	@Id
	@Column(name="t_id")
	private int tId ;
	
    @Column(name="change_from")
	private String changeFrom ; 
	
	@Column(name="change_to")
	private  String changeTo  ;
	
	@Column(name="Created_by")
	private String CreatedBy ;
	
	@Column(name="Created_date")
	private Date CreatedDate ;
	
	@Column(name="Modified_date")
	private Date ModifiedDate ;
	
	@Column(name="Modified_by")
	private String ModifiedBy;
	
	
	@OneToMany(targetEntity = Designation.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_ref", referencedColumnName = "e_id")
	List<Designation> desgList;
}
