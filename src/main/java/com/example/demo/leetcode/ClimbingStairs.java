package com.example.demo.leetcode;

public class ClimbingStairs {

	public static void main(String[] args) {
		int n = 5;
		System.out.println(climbStairs(n));
	}

	public static int climbStairs(int n) {

		if (n == 0 || n == 1)
			return 1;

		int f1 = 0;
		int f2 = 0;
		int sum = 0;
		for (int i = 0; i <= n; i++) {

			if (i == 0 || i == 1) {
				f1 = 1;
				f2 = 1;
				continue;
			}

			sum = f1 + f2;
			f1 = f2;
			f2 = sum;
		}

		return sum;

	}
}
