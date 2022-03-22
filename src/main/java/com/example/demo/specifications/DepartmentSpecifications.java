package com.example.demo.specifications;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo.Entity.Department;
import com.example.demo.Entity.Employee;
import com.example.demo.Entity.Student;

public class DepartmentSpecifications {

	public static Specification<Department> innerJoinEmployee() {

		/**
		 * root <-- 表示目前查詢的表或類別(from XXXX)，獲取列(欄位) 
		 * CriteriaQuery <-- 組合(where、order by)
		 * criteriaBuilder <-- 設置各種條件(就像是where後面的條件)
		 */
		return (Root<Department> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) -> {

			List<Predicate> predicates = new ArrayList<>();
			/*
			 * 面向物件來實現 這裡join的是Department類別中的employeeList
			 */
			Join<Department, Employee> innerJoin = root.join("employeeList", JoinType.INNER);
			// Department department = new Department();
			// department.setDeptNo(1001);

			/*
			 * 這裡指定的屬性名稱是Employee類別中的department
			 */
			// Predicate predicate = criteriaBuilder.equal(innerJoin.get("department"),
			// department);

			/*
			 * 透過innerJoin只能指定員工類別的屬性
			 */
			Predicate predicate =
			criteriaBuilder.equal(innerJoin.get("eName").as(String.class), "鳩摩智");
			predicates.add(predicate);
			// Predicate predicate =
			// criteriaBuilder.equal(root.get("name").as(String.class), "管理部");

			/*
			 * 查找多部門這裡使用in
			 */
			
			List<String> parentList = Arrays.asList(new String[]{"銷售部", "管理部"});
			Path<String> parentExpression = root.get("name");
			Predicate  inClausePredicate= parentExpression.in(parentList);
			predicates.add(inClausePredicate);
			Predicate[] p = predicates.toArray(new Predicate[predicates.size()]);

			Predicate finalPredicate = criteriaQuery.where(p).getRestriction();

			return finalPredicate;

		};
	}

}
