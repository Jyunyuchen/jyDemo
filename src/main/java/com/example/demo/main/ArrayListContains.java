package com.example.demo.main;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.domain.User;

public class ArrayListContains {

	public static void main(String[] args) {
		List<User> users = new ArrayList<>();
		User user1 = new User(1, "小明", "123");
		User user2 = new User(1, "小明", "1234");
		
		users.add(user1);
		
		// 要判斷一個「物件的內容」是否存在一個物件集合內
		// 需重寫hashCode以及equals方法
		// 這樣才會去比物件的內容，而不單只是比物件本身的記憶體位址
		// 這裡比的是，只要名字相同就判定是contains
		// 手動重寫equals方法
		System.out.println(users.contains(user2));

	}

}
