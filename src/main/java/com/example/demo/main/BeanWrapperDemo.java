package com.example.demo.main;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.example.demo.Entity.Student;

public class BeanWrapperDemo {

	//獲得一個物件的屬性名稱與值
	public static void main(String[] args) {
		
		Student student = new Student();
		student.setSno(1);
		student.setSage("20");
		student.setSname("王曉明");
		student.setSaddress("新北市");
		student.setSpwd("123456");
		
		BeanWrapper beanWrapper = new BeanWrapperImpl(student);
		PropertyDescriptor[] pds = beanWrapper.getPropertyDescriptors();
		
		for (PropertyDescriptor propertyDescriptor : pds) {
			//得到屬性名稱
			String propertyName = propertyDescriptor.getName();
			System.out.println("屬性值:" + propertyName);
			//利用屬性名稱獲得值
			System.out.println("值:" + beanWrapper.getPropertyValue(propertyName));
		}
	}

}
