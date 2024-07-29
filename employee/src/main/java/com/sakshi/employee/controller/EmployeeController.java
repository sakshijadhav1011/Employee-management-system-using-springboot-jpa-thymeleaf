package com.sakshi.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sakshi.employee.entity.Employee;
import com.sakshi.employee.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee")
	public String listEmployee(Model model) {
		model.addAttribute("employee", employeeService.getAllEmployee());
		return "employee";
	}
	
	@GetMapping("/employee/new")
	public String createEmployeeForm(Model model) {
		Employee emp = new Employee();
		model.addAttribute("employee", emp);
		return "create_employee";
	}
	
	@PostMapping("/employee")
	public String saveEmployee(@ModelAttribute("employee") Employee emp) {
		employeeService.saveEmployee(emp);
		return "redirect:/employee";
	}

	@GetMapping("/employee/edit/{id}")
	public String editEmployeeForm(@PathVariable("id") int id, Model model) {
	    model.addAttribute("employee", employeeService.getEmployeeById(id));
	    return "edit_employee";
	}
	
	@PostMapping("/employee/{id}")
	public String updateEmployee(@PathVariable("id") int id, @ModelAttribute("employee") Employee emp, Model model) {
	    // get student from db by id
	    Employee exiEmp = employeeService.getEmployeeById(id);
	    exiEmp.setId(id);
	    exiEmp.setName(emp.getName());
	    exiEmp.setEmail(emp.getEmail());
	    exiEmp.setDesignation(emp.getDesignation());
	    exiEmp.setSalary(emp.getSalary());
	    // save updated student object
	    employeeService.updateEmployee(exiEmp);
	    return "redirect:/employee";
	}
	
	@GetMapping("/employee/{id}")
	public String deleteStudent(@PathVariable int id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/employee";
	}
}
