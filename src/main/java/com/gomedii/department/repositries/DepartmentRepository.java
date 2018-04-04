package com.gomedii.department.repositries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gomedii.department.model.Department1;

public interface DepartmentRepository extends JpaRepository <Department1, Integer>{

	

	
}


