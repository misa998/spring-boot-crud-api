package com.misa.crudapi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.misa.crudapi.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> query = entityManager.createQuery("from Employee order by last_name", Employee.class);
		List<Employee> list = query.getResultList();
		return list;
	}

	@Override
	public Employee findId(int id) {
		Employee employee =	entityManager.find(Employee.class, id);
		if(employee == null) {
			throw new RuntimeException("Employee " + id + " not found");
		}
		return employee;
	}

	@Override
	public void save(Employee employee) {
		// add or update object
		// if id == 0 then save/insert, else update
		Employee employee2 = entityManager.merge(employee);
		// update with id from db, so we can get generated id for save/insert
		employee.setId(employee2.getId());
	}

	@Override
	public void delete(int id) {
		// javax.persistance.Query
		Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();
	}
}