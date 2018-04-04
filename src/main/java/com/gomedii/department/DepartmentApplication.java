package com.gomedii.department;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.gomedii.department.DepartmentApplication;
import com.gomedii.department.model.Department1;
import com.gomedii.department.repositries.DepartmentRepository;

@SpringBootApplication
public class DepartmentApplication implements ApplicationListener<ContextRefreshedEvent>{

	private Logger log = Logger.getLogger(DepartmentApplication.class);
	@Autowired
	DepartmentRepository department1Repository;
	
	public static void main(String[] args) {
		SpringApplication.run(DepartmentApplication.class, args);
	}
	
	
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		loadDepartment();
	}
	
	private void loadDepartment() {
		Department1 de = new Department1();

		de.setDid(1);
		de.setDname("IT");
		de.setEmpNo(20);
		department1Repository.save(de);

		log.info("department - id: " + de.getDid());



		Department1 d = new Department1();
		d.setDid(2);
		d.setDname("sales");
		d.setEmpNo(10);
		
		department1Repository.save(d);

		log.info("Saved department - id:" + d.getDid());

	}
}
