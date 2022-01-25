package com.example.demo.main;

public class StringBuilderDemo {

	public static void main(String[] args) {
		StringBuilder stringBuilder1 = new StringBuilder();
		stringBuilder1.append("a");
		StringBuilder stringBuilder2 = new StringBuilder();
		stringBuilder2.append(stringBuilder1);
		stringBuilder2.append("b");
		System.out.println(stringBuilder2.toString());
	}

}
