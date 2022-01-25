package com.example.demo.main;

import java.util.ArrayList;
import java.util.List;

public class Generic {

	public static void main(String[] args) {
		Student<Integer> student = new Student<Integer>(18);
		System.out.println(student.getAge()+"歲");
		
		/**
		 * E 能容納 String、Integer等等類型的其中一種
		 * 但不能容納自己E
		 * 
		 * 要表示能容納String、Integer等等所有類型必須用「?」
		 */
//		List<E> list = new ArrayList<>();
		List<?> list = new ArrayList<>();
	}
}

class Student<T>{
	
	private T age;
	
	public Student() {
		
	}

	public Student(T age) {
		super();
		this.age = age;
	}

	public T getAge() {
		return age;
	}

	public void setAge(T age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [age=" + age + "]";
	}
	
}
