package com.example.demo.Repository;

import com.example.demo.DTO.UserResponseVO;
import com.example.demo.Entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void test01() {

        String password = "123";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        password = bCryptPasswordEncoder.encode(password);

        User user =
                User.builder()
                        .userName("abc")
                        .password(password)
                        .createdTime(LocalDateTime.now())
                        .build();

        userRepository.save(user);

    }

    @Test
    void test02() {
        List<User> userList = userRepository.findAll();
        System.out.println("==============>" + userList);
    }

    @Test
    void test03() {
        UserResponseVO userResponseVO = userRepository.findUserByUserName("abc");
        System.out.println("==============>" + userResponseVO);
    }
}