package com.sakshi.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sakshi.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
