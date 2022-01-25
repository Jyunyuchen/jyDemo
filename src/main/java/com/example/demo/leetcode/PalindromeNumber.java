package com.example.demo.leetcode;

public class PalindromeNumber {

	public static void main(String[] args) {
		System.out.println(isPalindrome(-121));
	}

	public static boolean isPalindrome(int x) {

		String str = String.valueOf(x);
		int len = str.length();
		boolean flag = true;

		for (int i = 0; i < len; i++) {
			char forwardChar = str.charAt(i);
			char backwardChar = str.charAt(len - i - 1);
			if (forwardChar != backwardChar) {
				flag = false;
				break;
			}
		}
		return flag;
	}
}
