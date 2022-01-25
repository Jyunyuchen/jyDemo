package com.example.demo.leetcode;

/**
 * 69. Sqrt(x)
 * 
 * @author jy
 *
 */
public class Sqrt {

	public static void main(String[] args) {
		int x = 9;
		System.out.println(mySqrt(x));
	}

	public static int mySqrt(int x) {

		if (x == 0)
			return 0;

		if (x == 1)
			return 1;

		long min = 1;
		long max = x;

		while (max > min) {

			long middle = (min + max) / 2;
			long tempSquare = middle * middle;

			if (tempSquare == x) {
				return (int) middle;
			} else if (tempSquare > x) {
				max = middle - 1;
				long num = max * max;
				if (num == x) {
					return (int) max;
				} else if (num < x) {
					return (int) max;
				}
			} else if (tempSquare < x) {
				min = middle + 1;
				long num = min * min;
				if (num == x) {
					return (int) min;
				} else if (num > x) {
					return (int) middle;
				}
			}

		}

		return -5566;

	}
}
