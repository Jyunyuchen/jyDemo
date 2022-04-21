package com.example.demo.service.impl;

import com.example.demo.DTO.UserResponseVO;
import com.example.demo.Repository.UserRepository;
import com.example.demo.domain.JyLoginUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class JyUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 根據傳進來的username查詢DB中此用戶的資料
        UserResponseVO dbUser = userRepository.findUserByUserName(username);

        if(Objects.isNull(dbUser))
            throw new UsernameNotFoundException("該用戶不存在!!");

        // 返回UserDetails給Spring Security驗證，這裡返回實現類JyLoginUserDetails
        return new JyLoginUserDetails(dbUser);
    }
}
