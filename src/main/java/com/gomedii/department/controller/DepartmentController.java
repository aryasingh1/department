package com.gomedii.department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.gomedii.department.model.Department1;
import com.gomedii.department.model.View;

import com.gomedii.department.repositries.DepartmentRepository;
import com.gomedii.department.service.DepartmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/department")
@Api(value="office")
public class DepartmentController {

	@Autowired
    private DepartmentService departmentService;
	/*@Autowired
	private DepartmentRepository repo;*/

    @ApiOperation(value = "View a list of present department",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/api/departments", method= RequestMethod.GET, produces = "application/json")
    public Iterable<Department1> list(Model model){
        Iterable<Department1> departmentList = departmentService.listAllDepartment1();
        return departmentList;
    }
    
    @ApiOperation(value = "Search a department with an ID",response = Department1.class)
    @RequestMapping(value = "/api/departments/{id}", method= RequestMethod.GET, produces = "application/json")
    public Department1 showDepartment1(@PathVariable("did") Integer did, Model model){
    	Department1 department1 = departmentService.findOne(did);
        return department1;
    }

    @ApiOperation(value = "Add a department")
    @RequestMapping(value = "/api/departments", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> saveDepartment1(@RequestBody Department1 department1)
    {
    	departmentService.saveDepartment1(department1); 
    	return new ResponseEntity<String>("department saved successfully", HttpStatus.OK); 
    	
    }

    @ApiOperation(value = "Update a department")
    @RequestMapping(value = "/api/departments/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<String> updateEmployee(@PathVariable Integer id, @RequestBody Department1 department1){
    	Department1 storedDepartment1 = departmentService.findOne(id);
        storedDepartment1.setDid(department1.getDid());
        storedDepartment1.setDname(department1.getDname());
        storedDepartment1.setEmpNo(department1.getEmpNo());
        departmentService.saveDepartment1(storedDepartment1);
        return new ResponseEntity<String>("deaprtment updated successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a department")
    @RequestMapping(value="/api/departments/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        departmentService.deleteDepartment1(id);
        return new ResponseEntity<String>("department deleted successfully", HttpStatus.OK);

    }
   @GetMapping("/api/departments/{id}/summarry")
   @JsonView(View.Summery.class)
   public Department1 getSpecificDepartment1(@PathVariable(value="id") Integer Did)
   {
	  return departmentService.findOne(Did);
	 // return repo.findOne(id);
	   
   }
   @GetMapping("/getAll/{id}")
  
   public Department1 getAllDepartment1(@PathVariable(value="id") Integer Did)
   {
	  return departmentService.findOne(Did);
	 // return repo.findOne(id);
	   
   }
   
   }