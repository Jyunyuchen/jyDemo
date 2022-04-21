package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.OneToMany;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.DTO.DeptJoinEmpResponse;
import com.example.demo.Entity.Department;
import com.example.demo.Entity.Employee;
import com.example.demo.Repository.DepartmentRepository;
import com.example.demo.specifications.DepartmentSpecifications;

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
	
	/**
	 * Department inner join employee 查詢員工年齡<20
	 */
	@Test
	void test02() {
		List<Department> departmentList = departmentRepository.findByAgeJoinEmployee(20);
		for (Department department : departmentList) {
			System.out.println("=================>\n" + department);
			System.out.println("=================>\n" + department.getEmployeeList());
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
		employee.setEName("李四");
		employee.setAge(52);
		
		Employee employee2 = new Employee();
		employee2.setEName("王五");
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
	
	
	/**
	 * 使用Specification查詢
	 */
	@Test
	void test05() {
		List<Department> departmentList = departmentRepository.findAll(DepartmentSpecifications.innerJoinEmployee());
		for (Department department : departmentList) {
			System.out.println("===========>\n" + department);
			System.out.println("===========>\n" + department.getEmployeeList());
		}
	}
	
	/**
	 * 刪除某一個部門
	 */
	@Test
	void test06() {
		/*
		 * 若部門的主鍵有被員工表引用則會刪除失敗
		 */
		departmentRepository.deleteById(27);
	
	}
	
	/**
	 * 查詢部門，部門對應員工是@OneToMany，預設是懶加載
	 */
	@Test
	void test07() {
		List<Department> departments = departmentRepository.findAll();
		for (Department department : departments) {
			System.out.println(department);
			
			/*
			 * 若department.employeeList(調用員工資料)，
			 * 這樣會觸發再次去查詢員工資料，但session已關閉，會出現no session異常
			 * 必須設定:
			 *        (1)fetch=FetchType.EAGER 或者
			 *        (2)注入一個過濾器bean延長session
			 */
		}
	}
	
	/**
	 * 
     * Department join Employee
     * 查詢出部門底下有哪些員工
     * 只列出部門名稱以及員工姓名
     *
	 */
	@Test
	void test08() {
		List<DeptJoinEmpResponse> joinInformation = departmentRepository.getJoinInformation();
		System.out.println("=========> " + joinInformation);
	
	}
	
	/**
     * 查詢某部門底下有哪些員工(LEFT OUTER JOIN)
     * 因department屬於一的一方，預設抓取策略是懶加載
     * 這裡使用FETCH飢餓抓取
     */
	@Test
	void test09() {
		Department department = departmentRepository.getLeftOuterJoinInformation(1001);
		System.out.println("=========> " + department);
		System.out.println("=========> " + department.getEmployeeList());
	
		
	}
}
