package com.example.demo.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_emp")
@Getter
@Setter
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eid")
	private Integer eId;

	@Column(name = "ename")
	private String eName;

	@Column(name = "age")
	private Integer age;

	//@JsonIgnore
	@ManyToOne (
			//fetch=FetchType.EAGER
			//cascade = CascadeType.ALL
	)//(cascade = CascadeType.PERSIST)
	//name <-- 當前表中的外鍵名稱
	//referencedColumnName <-- 指向對方表中的主鍵名稱
	@JoinColumn(name = "dept_id", referencedColumnName = "deptno")
	private Department department;

	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", age=" + age + ", department=" + department + "]";
	}

	

}
