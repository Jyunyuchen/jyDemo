package com.example.demo.main;

import org.apache.commons.math3.stat.descriptive.summary.Sum;

public class Recursive1ToNDemo {

	public static int total = 0;

	public static void main(String[] args) {
//		sum1(200);
		total = sum2(5);
		System.out.println("答案==>" + total);
	}

	/*
	 * 1+2+3+....n
	 * 
	 * n=3
	 * return 3 + sum(3-1)
	 * 
	 * n=2
	 * return 2 + sum(2-1)
	 * 
	 * n=1
	 * return 1
	 */
	public static int sum2(int n) {

		if (n == 1)
			return 1;

		return n + sum2(n - 1);
	}

	/*
	 * 1+2+3+....n
	 */
	public static void sum1(int n) {

		if (n > 0) {
			total += n;
			sum1(--n);
		}
	}
}
