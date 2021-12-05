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
		
		/*
		 * 校驗電子郵件
		 */
		String email = "johannisber@gmail.com";
		/*
		 * 「\\w」代表任何[0—9A—Z_a—z]。多加一個"\"讓它脫逸
		 * 「{1,}」代表至少1位
		 * 「(\\.\\w{2,}){12}」代表後面的".com"至少出現一次最多兩次用"()"括起來
		 */
		b = email.matches("\\w{1,}@\\w{2,}(\\.\\w{2,}){1,2}");
		System.out.println(b);
	}

}
