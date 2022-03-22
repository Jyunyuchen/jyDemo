package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@PostMapping("/addEmployees")
	public List<Employee> addEmployees(@RequestBody List<Employee> employees) {
		System.out.println("=========> " + employees);
		return employeeService.saveEmployees(employees);
	}
	
	@GetMapping("/employees")
	public List<Employee> findAllEmployee(){
		List<Employee> employees = employeeService.findAllEmployee();
		
//		List<EmployeeDTO> resultEmployees = employees.stream()
//				 .map(employee -> {
//					 EmployeeDTO employeeDTO = new EmployeeDTO();
//					 BeanUtils.copyProperties(employee, employeeDTO);
//					 return employeeDTO;
//				 }).collect(Collectors.toList());
//		
//		System.out.println(resultEmployees);
		return employees;
	}
	
	@GetMapping("/employee/{ename}")
	public List<Employee> findEmployeeByName(@PathVariable(name = "ename") String ename){
		//System.out.println("===> " + ename);
		return employeeService.findEmployeeByName(ename);
	}
	
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}

}
