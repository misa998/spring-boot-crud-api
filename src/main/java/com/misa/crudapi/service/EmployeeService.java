package com.misa.crudapi.service;

import java.util.List;

import com.misa.crudapi.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	public Employee findId(int id);
	public void save(Employee employee);
	public void delete(int id);
}
