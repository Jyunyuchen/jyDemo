package com.example.demo.DataStructureAndAlgorithms;

/**
 * 0-1 Knapsack Problem | DP-10
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 * 
 * @author jy
 *
 */
public class KnapsackProblem {

	public static void main(String[] args) {

		// 物品的價值
		int val[] = new int[] { 60, 100, 120 };
		
		// 物品的重量
		int wt[] = new int[] { 10, 20, 30 };
		
		//背包的負重
		int W = 50;
		
		int n = val.length;
		System.out.println(knapSack(W, wt, val, n));

	}

	// Returns the maximum value that
	// can be put in a knapsack of
	// capacity W
	public static int knapSack(int W, int wt[], int val[], int n) {
		// Base Case
		if (n == 0 || W == 0)
			return 0;

		// If weight of the nth item is
		// more than Knapsack capacity W,
		// then this item cannot be included
		// in the optimal solution
		if (wt[n - 1] > W)
			return knapSack(W, wt, val, n - 1);

		// Return the maximum of two cases:
		// (1) nth item included
		// (2) not included
		else
			return max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1), 
					   knapSack(W, wt, val, n - 1));
	}

	// A utility function that returns
	// maximum of two integers
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

}
