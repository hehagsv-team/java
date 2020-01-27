package com.in28minutes.learning.jpa.jpain10steps.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.learning.jpa.jpain10steps.entity.Employee;

@Repository
//public interface EmployeeRepository extends CrudRepository<Employee,Serializable>{
public interface EmployeeRepository extends JpaRepository<Employee,Serializable>{
	List<Employee> findByEmpName (String empName);

}
