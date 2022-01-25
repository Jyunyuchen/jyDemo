package com.example.demo.leetcode;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] nums = { 3, 10, 2, 1 };
		System.out.println(lengthOfLIS(nums));
	}

	public static int lengthOfLIS(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		int result = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				System.out.printf("(%d,%d)", i, j);
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
			System.out.println();
			result = Math.max(dp[i], result);
		}
		return result;
	}
}
