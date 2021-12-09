package com.example.demo.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class User {
	
	private int id;

    @NotEmpty(message="使用者名稱不能為空")
    private String username;

    @NotEmpty(message="密碼不能為空")
    @Length(min=6, message="密碼長度不能少於六位")
    private String password;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
	
	
}
