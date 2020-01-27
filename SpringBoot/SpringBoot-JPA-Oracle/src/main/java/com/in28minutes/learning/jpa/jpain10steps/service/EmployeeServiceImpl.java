package com.in28minutes.learning.jpa.jpain10steps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in28minutes.learning.jpa.jpain10steps.entity.Employee;
import com.in28minutes.learning.jpa.jpain10steps.repository.EmployeeRepository;

@Component
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	private EmployeeRepository repository;
	
	@Override
	public boolean saveEmployee(Employee e) {
		
		Employee emp=repository.save(e);
		return (emp!=null)?true:false;
		
	}
	
	public Employee findByID (Integer empid) {
		return (repository.findById(empid)).get();
	}

	@Override
	public List<Employee> findByEmpName(String empName) {
		return repository.findByEmpName(empName);
		
	}




	
	
	
	
	

}
