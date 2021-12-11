package com.example.demo.main;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderDemo {

	public static void main(String[] args) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = "123456";
		String encodedPassword = passwordEncoder.encode(password);
		System.out.println();
		System.out.println("Password is:" + password);
		System.out.println("Encoded Password is:" + encodedPassword);
		System.out.println();
		
		//解密
		boolean isPasswordMatch = passwordEncoder.matches(password, encodedPassword);
		System.out.println("Password:" + password + "   isPasswordMatch:" + isPasswordMatch);
	}

}
