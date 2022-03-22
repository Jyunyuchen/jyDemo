package com.example.demo.Repository.customize;

import java.util.List;

import com.example.demo.Entity.Employee;

public interface EmployeeCustomerRepository {
	
	public List<Employee> customQuetyMethod(String employeeName);
	
}
