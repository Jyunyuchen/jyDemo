package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.Department;
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

    
    /**
     * 修改員工姓名，根據員工ID
     * @param name
     * @param eid
     */
    @Transactional
    @Modifying
   // @Query("UPDATE Employee e SET e.eName = :name WHERE e.eId = :eid")
    @Query("UPDATE Employee e SET e.eName = ?1 WHERE e.eId = ?2")
    void updateNameById(@Param("name") String name, @Param("eid") Integer eid);
    
    /**
     * 面向Entity查詢員工，傳入的參數是一個部門物件
     * @param department
     * @return
     */
    @Query("select e from Employee e where e.department = ?1")
    List<Employee> findByDepartmentObject(@Param("department") Department department);

}

