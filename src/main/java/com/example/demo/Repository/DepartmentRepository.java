package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.DTO.DeptJoinEmpResponse;
import com.example.demo.Entity.Department;
import com.example.demo.Entity.Student;
import com.example.demo.Entity.UsersOneToOne;

public interface DepartmentRepository extends JpaRepository<Department, Integer>, JpaSpecificationExecutor<Department> {

    @Query("SELECT d,e FROM Department d " +
            " INNER JOIN d.employeeList e " +
            " WHERE e.age < :age")
	List<Department> findByAgeJoinEmployee(@Param("age") Integer age);
    
    Department findOneByName(String name);
    
    /**
     * Department join Employee
     * 查詢出部門底下有哪些員工
     * 只列出部門名稱以及員工姓名
     */
    @Query("SELECT new com.example.demo.DTO.DeptJoinEmpResponse(d.name,e.eName)"
    		+ " FROM Department d " +
            " INNER JOIN d.employeeList e ")
    List<DeptJoinEmpResponse> getJoinInformation();
	
}
