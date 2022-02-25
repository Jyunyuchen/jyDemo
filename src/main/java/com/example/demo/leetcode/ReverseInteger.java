package com.example.demo.leetcode;

/**
 * 7. Reverse Integer
 * 
 * @author jy
 *
 */
public class ReverseInteger {

	public static void main(String[] args) {
		int x = -123;
		System.out.println(reverse(x));
	}

	public static int reverse(int x) {

		long sum = 0L;

		while (x != 0) {
			int remainder = x % 10;
			x = x / 10;
			sum = sum * 10 + remainder;
		}

		if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
			return 0;
		}

		return (int) sum;
	}
}
