package com.example.demo.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.authority.AuthorityUtils;

import javax.validation.constraints.NotEmpty;

@Data
public class MyUSer extends User{
    private int id;

    @NotEmpty(message="使用者名稱不能為空")
    private String username;

    @NotEmpty(message="密碼不能為空")
    @Length(min=6, message="密碼長度不能少於六位")
    private String password;

    public MyUSer(int id ,String username, String password) {
        super(id, username, password);
        this.id = id;
        this.username = username;
    }
}
