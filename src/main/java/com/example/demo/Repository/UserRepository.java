package com.example.demo.Repository;

import com.example.demo.DTO.UserResponseVO;
import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {

    @Query("SELECT new com.example.demo.DTO.UserResponseVO(u.userName,u.password)"
            + " FROM User u " +
            " WHERE u.userName = ?1")
    UserResponseVO findUserByUserName(String userName);

}
