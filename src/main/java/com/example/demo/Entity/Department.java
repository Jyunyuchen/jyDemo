package com.example.demo.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "t_dept")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "deptno")
	private Integer deptNo;
	
	@Column(name = "name")
	private String name;
	
	@JsonIgnore
	//mappedBy <-- 當前類在對方類中的屬性名稱(聲明主動放棄維護)
	//cascade <-- 當保存Department的時候，同時保存Employee
	@OneToMany(
			mappedBy = "department"
			//fetch=FetchType.EAGER
			//cascade = CascadeType.ALL
	)
	private List<Employee> employeeList = new ArrayList<>();;

	public Integer getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	@Override
	public String toString() {
		return "Department [deptNo=" + deptNo + ", name=" + name + "]";
	}
	
	

}
