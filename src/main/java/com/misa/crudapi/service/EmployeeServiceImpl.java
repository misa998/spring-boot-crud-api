package com.misa.crudapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misa.crudapi.dao.EmployeeDAO;
import com.misa.crudapi.dao.EmployeeRepository;
import com.misa.crudapi.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	//private EmployeeDAO employeeDAO;
	private EmployeeRepository employeeRep;
	
	@Autowired
	// @Qualifier("employeeDAOJpaImpl") EmployeeDAO... tells spring which bean to use
	// qualifier is not needed any more for spring data jpa rep
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRep = employeeRepository;
	}

	@Override
	// @Transactional
	// commented beacause jparepository provides it
	public List<Employee> findAll() {
		return employeeRep.findAll();
	}

	@Override
	public Employee findId(int id) {
		// using optional instead of checking for null
		Optional<Employee> result = employeeRep.findById(id);
		Employee emp = null;
		if(result.isPresent()) {
			emp = result.get();
		}else {
			throw new RuntimeException("Employee " + id + " not found.");
		}
		return emp;
	}

	@Override
	public void save(Employee employee) {
		employeeRep.save(employee);
	}

	@Override
	public void delete(int id) {
		employeeRep.deleteById(id);
	}

}
