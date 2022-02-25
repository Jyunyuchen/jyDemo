package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

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
	
	
	
	@Test
	@Rollback(false)
	@Transactional
	void test04() {
		
		// 查詢27號部門出來
		Optional<Department> department = departmentRepository.findById(27);
		
		// 拿到該部門所屬的員工
		List<Employee> employeeList = department.get().getEmployeeList();
		
		/*
		 * 將員工的外鍵關聯改為null，
		 * 加上@Transactional，會觸發hibernate執行update語句將外鍵關聯改為null
		 */
		for (Employee employee : employeeList) {
			employee.setDepartment(null);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
