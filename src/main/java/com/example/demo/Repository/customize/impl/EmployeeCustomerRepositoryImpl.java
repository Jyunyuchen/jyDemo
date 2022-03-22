package com.example.demo.Repository.customize.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.example.demo.Entity.Employee;
import com.example.demo.Repository.customize.EmployeeCustomerRepository;

public class EmployeeCustomerRepositoryImpl implements EmployeeCustomerRepository {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public List<Employee> customQuetyMethod(String employeeName) {

		String jpql = "SELECT e FROM Employee e WHERE e.eName = :name";
		Query query = entityManager.createQuery(jpql, Employee.class);
		query.setParameter("name", employeeName);
		List<Employee> employeeList = query.getResultList();
		return employeeList;

	}

}
