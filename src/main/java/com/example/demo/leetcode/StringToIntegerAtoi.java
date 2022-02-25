package com.example.demo.leetcode;

import org.hibernate.validator.constraints.Length.List;

public class StringToIntegerAtoi {

	public static void main(String[] args) {

		String s = "9223372036854775808";

		System.out.println(myAtoi(s));
	}

	public static int myAtoi(String s) {

		if (s.length() == 0) {
			return 0;
		}

		int idx = 0;

		// 忽略空白
		while (s.charAt(idx) == ' ') {
			idx++;
			if (idx > s.length() - 1){
				return 0;
			}
		}

		int negativeOrPositive = 1;
		if (s.charAt(idx) == '-' || s.charAt(idx) == '+') {
			negativeOrPositive = s.charAt(idx) == '-' ? -1 : 1;
			idx++;
		}

		long result = 0;
		for (int i = idx; i < s.length(); i++) {
			
			char c = s.charAt(i);

			// 如果是數字
			if (c <= 57 && c >= 48) {
				int integer = c - '0';
				result = result * 10 + integer;
			} else { // 不是數字
				break;
			}
			
			if (result * negativeOrPositive < Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			}

			if (result * negativeOrPositive > Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
		}

		

		// System.out.println(result*negativeOrPositive);

		return (int) result * negativeOrPositive;

	}

}
