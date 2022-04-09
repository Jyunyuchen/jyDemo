package com.example.demo.domain;

import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
	
	private int id;

    @NotEmpty(message="使用者名稱不能為空")
    private String username;

    @NotEmpty(message="密碼不能為空")
    @Length(min=6, message="密碼長度不能少於六位")
    private String password;
    

}
