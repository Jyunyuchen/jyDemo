package com.example.demo.main;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.domain.User;

public class ArrayListRemoveDemo {

	public static void main(String[] args) {
		List<User> users = new ArrayList<>();
		User user1 = new User(1, "小明", "123");
		User user2 = new User(2, "小英", "1234");
		users.add(user1);
		users.add(user2);
		
		System.out.println("移除前：" + users);
		
		User user3 = new User(1, "小明", "123");
		users.remove(user3);
		
		// 必須覆寫EqualsAndHashCode方法，移除一個自定義物件才會成功
		System.out.println("移除後：" + users);
	}

}
