package com.example.demo.main;

public class RegexDemo {

	public static void main(String[] args) {
		//匹配電話號碼
		String phoneNumber = "0919829156";
		/*
		 * 「09」===>表示必須為09開頭
		 * 「\\d」===>\d為正則的語法表示數字匹配，多加一個"\"讓他脫逸
		 * 「{8}」===>代表必須要有8位數
		 */
		boolean b = phoneNumber.matches("09\\d{8}");
		System.out.println(b);
	}

}
