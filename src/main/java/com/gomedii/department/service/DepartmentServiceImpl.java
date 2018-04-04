package com.gomedii.department.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomedii.department.model.Department1;
import com.gomedii.department.repositries.DepartmentRepository;
import com.gomedii.department.service.DepartmentService;
import com.gomedii.department.service.DepartmentServiceImpl;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);
    
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    public void setDepartmentRepository(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department1 saveDepartment1(Department1 department1) {
        logger.debug("saveDepartment1 called");
        return departmentRepository.save(department1);
    }
    
    @Override
    public Iterable<Department1> listAllDepartment1() {
        logger.debug("listAllDepartment called");
        return departmentRepository.findAll();
    }
/*@Override
    public Department1 getDepartment1ByDid(int id) 
    {
    	logger.debug("getDepartment1ById called");
      //return departmentRepository.find(Department1.class, 2);
    	//return departmentRepository.findById(Did);
		return null;
    }
    */

    @Override
    public void deleteDepartment1(Integer Did) {
        logger.debug("deleteEmployee called");
        //departmentRepository.delete(Did);
        departmentRepository.delete(Did);
    }

	@Override
	public Department1 getDepartment1ByDid(int Did) {
		logger.debug("getDepartment1ById called");
	      //return departmentRepository.find(Department1.class, 2);
	    	return departmentRepository.getOne(Did);
			//return null;
		//return null;
	}

	@Override
	public Department1 findOne(int Did) {
		
		
		return null;
	}
   
   
	
}

