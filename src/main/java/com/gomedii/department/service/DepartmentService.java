package com.gomedii.department.service;

import com.gomedii.department.model.Department1;

public interface DepartmentService {
	public abstract Iterable<Department1> listAllDepartment1();
	public abstract Department1 getDepartment1ByDid(int Did);
	public abstract Department1 saveDepartment1(Department1 department1);
	public abstract void deleteDepartment1(Integer Did);
	public abstract Department1 findOne(int Did);
	//Department1 getDepartment1ByDid(Int id);
	
	
	
	

}