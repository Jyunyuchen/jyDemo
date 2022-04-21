package com.example.demo.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.domain.User;

public class ArrayListRemoveAll {

	public static void main(String[] args) {
		List<User> users = new ArrayList<>();
		User user1 = new User(1, "小明", "123");
		User user2 = new User(2, "小華", "1234");
		User user3 = new User(3, "小藍", "abc123");
	
		users.add(user1);
		users.add(user2);
		users.add(user3);
		
		List<User> remove = new ArrayList<>();
		remove.add(user1);
		
		System.out.println("移除前：" + users);
		
		// 這裡移除的是比較記憶體位址
		// 當初add跟remove是同一個物件uesr1所以可以移除成功
		// 如果有其他情況無法比較記憶體位址
		// 則可覆寫hash以及equals方法比較屬性值來做移除
		users.removeAll(remove);
		
		System.out.println("移除後：" + users);
	}

}
