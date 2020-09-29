package com.misa.crudapi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.misa.crudapi.dao.EmployeeDAO;
import com.misa.crudapi.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRESTController {
	
	private EmployeeDAO employeeDAO;
	
	// inject employee dao
	@Autowired
	public EmployeeRESTController(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	@GetMapping("/")
	public String home() {
		return "Hello";
	}
	
	@GetMapping("/employees")
	public List<Employee> list(){
		return employeeDAO.findAll();
	}
}
