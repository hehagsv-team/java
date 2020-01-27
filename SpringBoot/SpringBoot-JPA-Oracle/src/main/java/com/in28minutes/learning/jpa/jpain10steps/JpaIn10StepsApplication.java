package com.in28minutes.learning.jpa.jpain10steps;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import com.in28minutes.learning.jpa.jpain10steps.entity.Employee;
import com.in28minutes.learning.jpa.jpain10steps.repository.EmployeeRepository;
import com.in28minutes.learning.jpa.jpain10steps.service.EmployeeServiceImpl;
import com.in28minutes.learning.jpa.jpain10steps.service.IEmployeeService;

@SpringBootApplication
public class JpaIn10StepsApplication {


//	@Autowired
//	private EmployeeRepository repository;
	
	public static void main(String[] args) {
		ApplicationContext ac=SpringApplication.run(JpaIn10StepsApplication.class, args);
		
		IEmployeeService service=ac.getBean(EmployeeServiceImpl.class);
		Employee emp=new Employee();

		emp.setEmpName("Simba");
		emp.setEmpSal(10000.00);
		
		boolean status=service.saveEmployee(emp);
		if(status)
			System.out.println("Data inserted");
		else
			System.out.println("Not Inserted");
//		System.out.println("Getting the details");
//		Long id=1L;
		
		Employee emp2 = service.findByID(new Integer (22));
		System.out.println(emp2.toString());
		
		List<Employee> empList = service.findByEmpName("Simba");
		for (Iterator iterator = empList.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			System.out.println("Employee == "+employee);	
		}
		
		
		
	}

	/*public static void main(String[] args) {
		ApplicationContext ac=SpringApplication.run(JpaIn10StepsApplication.class, args);
		
		JpaIn10StepsApplication app = new JpaIn10StepsApplication();
		
//		IEmployeeService service=ac.getBean(EmployeeServiceImpl.class);
		Employee emp=new Employee();

		emp.setEmpName("Simba");
		emp.setEmpSal(10000.00);
		
		Employee status=app.repository.save(emp);
		if(status !=null)
			System.out.println("Data inserted "+ status);
		else
			System.out.println("Not Inserted");
//		System.out.println("Getting the details");
//		Long id=1L;
		
		
	}
*/
}
