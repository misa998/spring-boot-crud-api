package com.misa.crudapi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.misa.crudapi.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	private EntityManager entityManager;

	// constructor injection
	@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	// @Transactional is removed because it will be added on Service
	@Override
	public List<Employee> findAll() {
		// getting current hibernate session
		Session session = entityManager.unwrap(Session.class);
		Query<Employee> query = session.createQuery("from Employee", Employee.class);
		List<Employee> result = query.getResultList();
		return result;
	}
	
	@Override
	public Employee findId(int id) {
		Session session = entityManager.unwrap(Session.class);
		Employee emp = session.get(Employee.class, id);
		return emp;
	}

	@Override
	public void save(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(employee);
	}

	@Override
	public void delete(int id) {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("delete from Employee where id=:employeeId;");
		query.setParameter("employeeId", id);
		query.executeUpdate();
	}	
}
