package com.example.demo.service;

import java.util.List;

import com.example.demo.Entity.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee);
	
	List<Employee> findAllEmployee();

	List<Employee> saveEmployees(List<Employee> employees);

	List<Employee> findEmployeeByName(String ename);
	
	Employee updateEmployee(Employee employee);

}
