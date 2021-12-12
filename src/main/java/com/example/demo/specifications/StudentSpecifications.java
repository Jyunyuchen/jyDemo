package com.example.demo.specifications;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.example.demo.Entity.Student;

public class StudentSpecifications {
	
	@SuppressWarnings("serial")
	public static Specification<Student> getStudentByName(String name,  String age) {
		return new Specification<Student>() {
			@Override
			public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				
				List<Predicate> predicates = new ArrayList<>();
				Path<String> snameColumn = root.get("sname");
				Path<String> sageColumn = root.get("sage");
				if(!StringUtils.isEmpty(age)) {
					Predicate equalPredicate = criteriaBuilder.equal(sageColumn, age);
					predicates.add(equalPredicate);
				}
				
				if(!StringUtils.isEmpty(name)) {
					Predicate likePredicate = criteriaBuilder.like(snameColumn, name);
					predicates.add(likePredicate);
				}
				
				 Predicate[] p = predicates.toArray(new Predicate[predicates.size()]);
				 //Predicate likeEqualPredicate = criteriaBuilder.and(p);
				 
				 Predicate likeEqualPredicate = null;
				 Order orderByAge = criteriaBuilder.desc(sageColumn);
				 
				 likeEqualPredicate = query.where(p).orderBy(orderByAge).getRestriction();
				 
				return likeEqualPredicate;
			}// 實做的方法
		};// new的物件
	}// 方法
	
	
	public static Specification<Student> getStudentByNameSpec(String name) {
		return new Specification<Student>() {
			@Override
			public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				Predicate equalPredicate = criteriaBuilder.equal(root.get("sname"), name);
				return equalPredicate;
			}// 實做的方法
		};// new的物件
	}// 方法

	public static Specification<Student> getStudentByNameLikeAndequal(String likeName, String equalAge) {
		return new Specification<Student>() {
			@Override
			public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

				Predicate likeEqualPredicate = null;
				Predicate likePredicate = criteriaBuilder.like(root.get("sname"), likeName);
				if (equalAge != null) {
					Predicate equalPredicate = criteriaBuilder.equal(root.get("sage"), equalAge);
					likeEqualPredicate = criteriaBuilder.and(likePredicate, equalPredicate);
				} else {
					likeEqualPredicate = criteriaBuilder.and(likePredicate);
				}

				return likeEqualPredicate;
			}// 實做的方法
		};// new的物件
	}// 方法
}
