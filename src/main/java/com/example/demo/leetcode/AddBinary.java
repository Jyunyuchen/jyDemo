package com.example.demo.leetcode;

/**
 * 67. Add Binary
 * 
 * @author jy
 *
 */
public class AddBinary {

	public static void main(String[] args) {
		String a = "11";
		String b = "1";
		System.out.println(addBinary(a, b));
	}

	public static String addBinary(String a, String b) {
		int i = a.length() - 1;
		int j = b.length() - 1;

		StringBuilder sb = new StringBuilder();

		int carry = 0;

		while (i >= 0 || j >= 0) {

			int num1 = i >= 0 ? a.charAt(i) - '0' : 0;
			int num2 = j >= 0 ? b.charAt(j) - '0' : 0;
			int sum = num1 + num2 + carry;
			carry = sum / 2;
			int remainder = sum % 2;

			sb.append(remainder);

			i--;
			j--;

		}

		if (carry > 0) {
			sb.append(carry);
		}

		return sb.reverse().toString();

	}
}
