package com.example.demo.controller;

import com.example.demo.DTO.UserResponseVO;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

    @Autowired
    LoginService loginService;

    @PostMapping("/jyLogin")
    public String login(@RequestBody UserResponseVO user){
        loginService.login(user);
        return "登入成功";
    }

    @GetMapping("/loginTest")
    public String loginTest(@RequestParam String password){
        if("12345".equals(password)){
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken("Jy","12345", null);
            SecurityContextHolder.getContext().setAuthentication(auth);
            return "登入成功";
        }
        SecurityContextHolder.getContext().setAuthentication(null);
        return "登入失敗";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
