package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Entity.Department;
import com.example.demo.Entity.Employee;
import com.example.demo.Repository.DepartmentRepository;

@SpringBootTest
public class DepartmentTest {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Test
	void test01() {
		List<Department> departmentList = departmentRepository.findAll();
		for (Department department : departmentList) {
			System.out.println("=================>\n" + department);
		}
	}
	
	@Test
	void test02() {
		List<Department> departmentList = departmentRepository.findByAgeJoinEmployee(20);
		for (Department department : departmentList) {
			System.out.println("=================>\n" + department);
		}
	}
	
	
	/**
	 * 插入部門同時插入員工
	 */
	@Test
	void test03() {
		
		Department department = new Department();
		department.setName("人事部");
		
		Employee employee = new Employee();
		employee.seteName("李四");
		employee.setAge(52);
		
		Employee employee2 = new Employee();
		employee2.seteName("王五");
		employee2.setAge(12);
		
		department.getEmployeeList().add(employee);
		department.getEmployeeList().add(employee2);
		employee.setDepartment(department);
		employee2.setDepartment(department);
		
		departmentRepository.save(department);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
