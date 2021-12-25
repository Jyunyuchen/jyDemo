package com.example.demo.main;

import java.util.HashSet;
import java.util.Objects;

public class HashSetExcludeDuplicates {

	public static void main(String[] args) {
		HashSet<Person> personSet = new HashSet<>();
        personSet.add(new Person("曹操", "123"));
        personSet.add(new Person("孙权", "123"));
        personSet.add(new Person("曹操", "123"));
        // 循环打印 HashSet 中的所有元素
        personSet.forEach(p -> System.out.println(p));
	}
}

class Person {
    private String name;
    private String password;

    public Person(String name, String password) {
        this.name = name;
        this.password = password;
    }

    
	@Override
	public int hashCode() {
		
		System.out.println("hash");
		// 对比 name 和 password 是否相等
		//return Objects.hash(name, password);
		
		// 对比 name是否相等
		return Objects.hash(name);
	}


	@Override
	public boolean equals(Object obj) {
		
		System.out.println("equals");
		
		// 引用相等返回 true
		if (this == obj)
			return true;
		
		 // 如果等于 null 返回 false
		if (obj == null)
			return false;
		
		//或者对象类型不同返回 false
		if (getClass() != obj.getClass())
			return false;
		
		Person other = (Person) obj;
		// 如果 name 和 password 都相等，就返回 true
		//return Objects.equals(this.name, other.name) && Objects.equals(this.password, other.password);
		// 如果 name相等(只比較name)，就返回 true
		return Objects.equals(this.name, other.name);
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "Person [name=" + name + ", password=" + password + "]";
	}
    
    
}