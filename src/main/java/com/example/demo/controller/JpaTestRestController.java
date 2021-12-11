package com.example.demo.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentRepository;

@RestController
@RequestMapping("/test")
public class JpaTestRestController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	/**
	 * 更新學生訊息
	 * @param sno
	 * @param student
	 * @return
	 */
	@PutMapping("/student/{sno}")
	public String updateStudent(@PathVariable("sno") int sno, @RequestBody Student student) {
		Student dbStudent = studentRepository.findOneBySno(sno);
		if(ObjectUtils.isEmpty(dbStudent)) {
			return "該學生不存在";
		}
		
		//做法1
		/*BeanUtils.copyProperties(student, dbStudent);
		dbStudent.setSno(sno);
		studentRepository.save(dbStudent);*/
		
		//做法2
		//設定主鍵後去save即是執行update
		student.setSno(sno);
		studentRepository.save(student);
		return "修改成功";
	}

}
