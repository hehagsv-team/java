package com.in28minutes.learning.jpa.jpain10steps.service;

import java.util.List;
import java.util.Optional;

import com.in28minutes.learning.jpa.jpain10steps.entity.Employee;

public interface IEmployeeService {
	
	public boolean saveEmployee(Employee e);
//	Optional <Employee> findById(Long id);
	
	public Employee findByID (Integer empid);
	
	public List<Employee> findByEmpName (String empName);
	
	
}
