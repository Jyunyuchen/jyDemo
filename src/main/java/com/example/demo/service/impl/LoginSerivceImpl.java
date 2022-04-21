package com.example.demo.service.impl;

import com.example.demo.DTO.UserResponseVO;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
        Authentication authenticate = authenticationManagerBean.authenticate(usernamePasswordAuthenticationToken);

        // 如果authenticate為null表示驗證沒通過
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("登入失敗");
        }

        //如果認證沒通過，給出對應的提示

        //認證通過，根據用戶姓名生成JWT



    }
}
