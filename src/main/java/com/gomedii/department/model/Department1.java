package com.gomedii.department.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonView;
import com.gomedii.department.model.View;

import io.swagger.annotations.ApiModelProperty;
@Entity
public class Department1 {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated deoartment ID")
    @Column(name="did")
    private int did;
	
	@JsonView(View.Summery.class)
	@ApiModelProperty(notes = "The application-specific department name")
    @Column(name="department_name")
    private String dname;
	
	@JsonView(View.Summery.class)
	@ApiModelProperty(notes = "The application-specific department no of employee")
    @Column(name="empNo")
    private Integer empNo;

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
