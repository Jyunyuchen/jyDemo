package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e " +
            " LEFT JOIN e.department d " +
            " WHERE e.age < :age")
    List<Employee> findByAgeLessThanLeftJoinDepartment(@Param("age") Integer age);
    
    @Query("SELECT e FROM Employee e " +
            " LEFT JOIN e.department d " +
            " WHERE e.age < :age " +
            " and d.deptNo = :deptNo ")
    List<Employee> findByAgeAndDepartmentId(@Param("age") Integer age, @Param("deptNo") Integer deptNo);


}

