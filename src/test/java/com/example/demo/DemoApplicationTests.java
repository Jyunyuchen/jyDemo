package com.example.demo;

import java.util.List;

import org.hibernate.annotations.Where;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.specifications.StudentSpecifications;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	StudentRepository studentRepository;
	
	@Test
	void contextLoads1() {
		List<Student> students = studentRepository.findAll();
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
	@Test
	void contextLoads2() {
		Student student = new Student();
		student.setSname("林建璋");
		student.setSage("20");
		student.setSaddress("台南市");
		student.setSpwd("123456");
		studentRepository.save(student);
	}
	
	@Test
	void contextLoads3() {
		String name = "林建璋";
		Student student = studentRepository.selectByName(name);
		System.out.println(student);
	}
	
	//調用JpaSpecificationExecutor
	@Test
	void contextLoads4() {
		//System.out.println(studentRepository.findAll(StudentSpecifications.getStudentByNameLike("%明%")));
		System.out.println(studentRepository.findAll(StudentSpecifications.getStudentByNameLikeAndequal("%明%", null)));
				
	}
	
	//使用JPQL語法查詢特定的欄位
	@Test
	void contextLoads5() {
		System.out.println(studentRepository.fineBySpecificColumns(1));
	}
	
	//調用JpaSpecificationExecutor
	@Test
	void contextLoads6() {
		System.out.println(studentRepository.findAll(StudentSpecifications.getStudent("%明%", "15","台北")));
				
	}

	/**
	 * 先查詢學生，再刪除
	 */
	@Test
	void contextLoads7() {
		Student student = studentRepository.findOneBySno(1);
		System.out.println("=============>\n" + student);
		studentRepository.delete(student);
	}
}
