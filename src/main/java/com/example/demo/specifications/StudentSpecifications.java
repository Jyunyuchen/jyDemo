package com.example.demo.specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo.Entity.Student;

public class StudentSpecifications {
	public static Specification<Student> getStudentByNameSpec(String name) {
		  return new Specification<Student>() {
			@Override
			public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				Predicate equalPredicate = criteriaBuilder.equal(root.get("sname"), name);
                return equalPredicate;
			}//實做的方法
		  };//new的物件
	}// 方法
	
	public static Specification<Student> getStudentByNameLike(String name) {
		  return new Specification<Student>() {
			@Override
			public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				Predicate equalPredicate = criteriaBuilder.like(root.get("sname"), name);
              return equalPredicate;
			}//實做的方法
		  };//new的物件
	}// 方法
}
