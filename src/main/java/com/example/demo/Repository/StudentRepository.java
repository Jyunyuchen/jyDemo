package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student> {

	/*@Query("INSERT INTO student (sname, sage, saddress, spwd) VALUES (:#{#student.sname}, :#{#student.sage}, :#{#student.saddress, :#{#student.spwd})")
	void insert(@Param("student") Student student);*/
	
	@Query(nativeQuery = true, value = "SELECT * FROM student s WHERE s.sname = :name")
	Student selectByName(@Param("name") String name);
	
	boolean existsBySname(String sname);
	
	Student findOneBySno(int sno);
	
	//使用JPQL語法查詢特定的欄位
	@Query("SELECT new Student(s.sno, s.sname, s.sage) FROM Student s WHERE s.sno = ?1")
	List<Student> fineBySpecificColumns (int sno);
	
	
}
