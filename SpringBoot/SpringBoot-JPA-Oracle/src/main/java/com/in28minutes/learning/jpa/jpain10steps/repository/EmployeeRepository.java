package com.in28minutes.learning.jpa.jpain10steps.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.learning.jpa.jpain10steps.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Serializable>{
	
	

}
