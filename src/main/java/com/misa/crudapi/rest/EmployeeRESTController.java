package com.misa.crudapi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/employees/{employeeId}")
	public Employee employeeById(@PathVariable int employeeId){
		Employee employee = employeeService.findId(employeeId);
		if(employee == null) {
			throw new RuntimeException("Employee " + employeeId + " not found");
		}
		return employee;
	}
	
	@PostMapping("/employees")
	public Employee add(@RequestBody Employee employee) {
		employee.setId(0);
		employeeService.save(employee);
		
		return employee;
	}
	
	@PutMapping("/employees")
	public Employee update(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String delete(@PathVariable int employeeId) {
		Employee employee = employeeService.findId(employeeId);
		if(employee == null) {
			throw new RuntimeException("Employee " + employeeId + " not found");
		}
		employeeService.delete(employeeId);
		
		return "Employee " + employeeId + " deleted.";
	}
}
