package com.example.demo.DataStructureAndAlgorithms;

public class FibonacciDemo {

	static long[] memory = new long[51];

	public static void main(String[] args) {
		// System.out.println(fibonacci(4));
		for (int i = 0; i < memory.length; i++) {
			memory[i] = -1L;
		}

		long start = System.currentTimeMillis();
		System.out.println("開始時間:" + start);
		//System.out.println(fibonacciByMemory(memory.length - 1));
		//System.out.println(fibonacci(50));
		System.out.println(fibonacciWithForLoop(2));
		long end = System.currentTimeMillis();
		System.out.println("結束時間:" + end);
		String result = String.valueOf(end - start);
		System.out.printf("執行了 %s 毫秒", result);

		/*
		 * System.out.println(); for (int i = 0; i < memory.length; i++) {
		 * System.out.printf("memory[%d]=%d", i, memory[i]); System.out.println(); }
		 */
	}

	/**
	 * fibonacci
	 * 
	 * @param n
	 * @return
	 */
	public static long fibonacci(long n) {
		if (n == 0 || n == 1)
			return n;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	/*
	 * 動態規劃解fibonacci
	 * 
	 */
	public static long fibonacciByMemory(int n) {
		if (n == 0 || n == 1)
			memory[n] = n;

		if (memory[n] == -1)
			memory[n] = fibonacciByMemory(n - 1) + fibonacciByMemory(n - 2);

		return memory[n];
	}

	/**
	 * for loop 解 fibonacci
	 * 
	 * @param n
	 * @return
	 */
	public static long fibonacciWithForLoop(int n) {

		if (n == 0 || n == 1)
			return n;
		
		long f1 = 0L;
		long f2 = 0L;
		long sum = 0L;
		boolean flag = false;
		for (int i = 0; i <= n; i++) {

			if (i == 2) {
				flag = false;
			}

			if (i == 0) {
				f1 = i;
				flag = true;
			}

			if (i == 1) {
				f2 = i;
				flag = true;
			}

			if (!flag) {
				sum = f1 + f2;
				f1 = f2;
				f2 = sum;
			}

		}

		return sum;
	}
}
