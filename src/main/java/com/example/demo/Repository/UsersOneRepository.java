package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Student;
import com.example.demo.Entity.UsersOneToOne;

@Repository
public interface UsersOneRepository extends JpaRepository<UsersOneToOne, Integer> {

}
