package com.misa.crudapi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.misa.crudapi.entity.Employee;
import com.misa.crudapi.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRESTController {
	
	private EmployeeService employeeService;
	
	// inject employee service
	@Autowired
	public EmployeeRESTController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/")
	public String home() {
		return "Hello";
	}
	
	@GetMapping("/employees")
	public List<Employee> list(){
		return employeeService.findAll();
	}
}
