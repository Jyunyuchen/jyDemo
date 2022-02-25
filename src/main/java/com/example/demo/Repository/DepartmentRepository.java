package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entity.Department;
import com.example.demo.Entity.UsersOneToOne;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query("SELECT d,e FROM Department d " +
            " JOIN d.employeeList e " +
            " WHERE e.age < :age")
	List<Department> findByAgeJoinEmployee(@Param("age") Integer age);
	
}
