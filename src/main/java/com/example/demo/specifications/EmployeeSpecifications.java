package com.example.demo.specifications;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo.Entity.Department;
import com.example.demo.Entity.Employee;

public class EmployeeSpecifications {

	/**
	 * 查詢某部門年齡大於age的員工
	 * 例如：查詢銷售部中年齡大於50的員工
	 * 
	 * @return
	 */
	public static Specification<Employee> innerJoinDept(String deptName, Integer age) {
		return (Root<Employee> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) -> {

			List<Predicate> predicates = new ArrayList<>();
			
			/*
			 *  先innerJoin員工表
			 *  join裏頭的「department」是員工類別中的Department屬性名稱
			 */
			Join<Employee, Department> innerJoin = root.join("department", JoinType.INNER);
			
			/*
			 * 設定要查詢的部門條件
			 */
			Predicate predicate1 = criteriaBuilder.equal(innerJoin.get("name").as(String.class), deptName);
			predicates.add(predicate1);
			
			/*
			 * 設定年齡條件
			 */
			Predicate predicate2 = criteriaBuilder.ge(root.get("age").as(Integer.class), age);
			predicates.add(predicate2);
			
			Predicate[] p = predicates.toArray(new Predicate[predicates.size()]);
			Order orderByAge = criteriaBuilder.desc(root.get("age"));
			Predicate finalPredicate = criteriaQuery.where(p).orderBy(orderByAge).getRestriction();

			return finalPredicate;
		};
	}

}
