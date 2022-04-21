package com.example.demo.service.impl;

import com.example.demo.DTO.UserResponseVO;
import com.example.demo.service.LoginService;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginSerivceImpl implements LoginService {

    @Autowired
    AuthenticationManager authenticationManagerBean;


    @Override
    public void login(UserResponseVO user) {
        // 獲取AuthenticationManager，好開啟Spring Security一連串的驗證流程
        // 獲取AuthenticationManager進行用戶認證，這裡使用實現類authenticationManagerBean
        // authenticationManagerBean.authenticate(Authentication)，參數為介面Authentication
        // 使用實現類UsernamePasswordAuthenticationToken傳入
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());

        Authentication authenticate = null;
        try {
            authenticate = authenticationManagerBean.authenticate(usernamePasswordAuthenticationToken);
        } catch (AuthenticationException e) {
            // 驗證不通過會拋異常
           // System.out.println("====>" + ReflectionToStringBuilder.toString(authenticate, ToStringStyle.MULTI_LINE_STYLE));
            System.out.println("==========>"+e.getMessage());
            e.printStackTrace();
            System.out.println("==========>" + "登入失敗");
        }
//
//        SecurityContextHolder.getContext().setAuthentication(authenticate);
//
//        Authentication authenticationFromContext = SecurityContextHolder.getContext().getAuthentication();
//
//        System.out.println(ReflectionToStringBuilder.toString(authenticationFromContext, ToStringStyle.MULTI_LINE_STYLE));

        //如果認證沒通過，給出對應的提示

        //認證通過，根據用戶姓名生成JWT



    }
}
