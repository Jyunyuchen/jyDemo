package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Entity.student;
import com.example.demo.Repository.StudentRepository;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	StudentRepository studentRepository;
	
	@Test
	void contextLoads() {
		List<student> students = studentRepository.findAll();
		for (student student : students) {
			System.out.println(student);
		}
	}

}
