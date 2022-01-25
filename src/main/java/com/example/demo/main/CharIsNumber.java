package com.example.demo.main;

public class CharIsNumber {

	public static void main(String[] args) {
		char c = 's';
		
		/*
		 * ASCII中:
		 * 數字0編號為48、數字1編號為49、、數字9編號為57
		 */
		if(c<=57 && c>=48) {
			System.out.println("是個數字!!");
		}else {
			System.out.println("不是數字!!");
		}
		

	}

}
