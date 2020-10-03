package com.misa.crudapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.misa.crudapi.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
