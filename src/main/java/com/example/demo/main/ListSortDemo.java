package com.example.demo.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortDemo {

	public static void main(String[] args) {
		ArrayList<User> list = new ArrayList<>();
		list.add(new User(1, "王小明"));
		list.add(new User(3, "李大華"));
		list.add(new User(2, "張小嘉"));

		System.out.println("排序前:" + list);
		
		Collections.sort(list, new Comparator<User>() {
			@Override
			public int compare(User o1, User o2) {
				return Integer.valueOf(o1.getId()).compareTo(Integer.valueOf(o2.getId()));
			}
		});
		
		System.out.println("排序後:" + list);
	}

}

class User {

	private Integer id;
	private String name;

	public User(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

}