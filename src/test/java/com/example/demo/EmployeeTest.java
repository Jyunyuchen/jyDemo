package com.example.demo;

import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Entity.Department;
import com.example.demo.Entity.Employee;
import com.example.demo.Repository.DepartmentRepository;
import com.example.demo.Repository.EmployeeRepository;

@SpringBootTest
public class EmployeeTest {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	void test01() {
		  List<Employee> employeeList = employeeRepository.findByAgeLessThanLeftJoinDepartment(20);
		  for (Employee employee : employeeList) {
			System.out.println("============>\n" + employee + employee.getDepartment());
			
		}
	}
	
	@Test
	void test02() {
		Employee employee = new Employee();
		employee.seteName("李四");
		employee.setAge(52);

		/*
		 * 若設定cascade會認為是要在插入一條Department資料，
		 * 而不是根據外鍵1004插入一筆關連到1004的資料，
		 * 所以不能設定cascade = CascadeType.PERSIST
		 * 
		 */
		Department department = new Department();
		department.setDeptNo(1004);
		//department.setName("人事部");
		
		employee.setDepartment(department);
		
		employeeRepository.save(employee);
		
	}
	

	@Test
	void test03() {
		  List<Employee> employeeList = employeeRepository.findByAgeAndDepartmentId(20,1001);
		  for (Employee employee : employeeList) {
			System.out.println("============>\n" + employee + employee.getDepartment());
		}
	}
	
	
}
