package com.example.demo.main;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class PassByValueAndPassByReference {

	public static void main(String[] args) {
		A a = new A(1);
		System.out.println("a address: " + a);
		System.out.println("修改前: " + a.getI());
		modify1(a);
		System.out.println("修改後: " + a.getI());
	}
	
	public static void modify1(A a1) {
		System.out.println("a1 address: " + a1);
		a1.setI(a1.getI()+1);
		
	}

}

@Getter
@Setter
class A{
	
	private int i;

	public A(int i) {
		super();
		this.i = i;
	}
}