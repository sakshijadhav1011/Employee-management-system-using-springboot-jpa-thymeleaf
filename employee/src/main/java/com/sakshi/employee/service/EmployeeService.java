package com.sakshi.employee.service;

import java.util.List;

import com.sakshi.employee.entity.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployee();
	Employee saveEmployee(Employee emp);
	
	Employee updateEmployee(Employee emp);
	Employee getEmployeeById(int id);
	
	void deleteEmployeeById(int id);
}
