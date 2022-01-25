package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 53. Maximum Subarray https://leetcode.com/problems/maximum-subarray/
 * 
 * @author jy
 *
 */
public class MaximumSubarray {

	public static void main(String[] args) {
		//int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		//int[] nums = { 1, 2, 3 };
		int[] nums = { -2, 1, -3, 4, -1, 2 };

		// int[] nums = { 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArray(nums));
		// System.out.println(combination(nums));
		// System.out.println(maxSubArrayBruteForce(nums));
	}

	/*
	 * 動態規劃
	 */
	public static int maxSubArray(int[] nums) {

		// nums = { -2, 1, -3, 4, -1, 2 };

		List<Integer> maxList = new ArrayList<>();

		int[] memoization = new int[nums.length];
		memoization[0] = nums[0];

		int startIndex = 0;
		boolean flag = false;

		for (int i = 1; i < nums.length; i++) {

			// 不與前面合併
			if (nums[i] > memoization[i - 1] + nums[i]) {
				memoization[i] = nums[i];
				flag = false;
			} else { // 與前面合併
				if (!flag) {
					startIndex = i - 1;
				}
				flag = true;
				memoization[i] = memoization[i - 1] + nums[i];
			}
		}

		for (int i = 0; i < memoization.length; i++) {
			System.out.printf("memoization[%d]=%d\n", i, memoization[i]);

		}

		int largestSum = memoization[0];
		int endIndex = 0;
		for (int i = 1; i < memoization.length; i++) {
			if (memoization[i] > largestSum) {
				largestSum = memoization[i];
				endIndex = i;
			}
		}

		for (int i = endIndex; i >= startIndex; i--) {
			if (i - 1 >= startIndex) {
				Integer element = memoization[i] - memoization[i - 1];
				maxList.add(0, element);
			} else {
				maxList.add(0, memoization[i]);
			}
		}

		System.out.println(maxList);
		System.out.println("startIndex=" + startIndex);
		System.out.println("endIndex=" + endIndex);
		return largestSum;

	}

	/*
	 * 暴力求解2層for迴圈
	 */
	public static int maxSubArrayBruteForce(int[] nums) {

		List<List<Integer>> combinationList = new ArrayList<>();
		int max = nums[0];

		for (int i = 0; i < nums.length; i++) {
			List<Integer> subArrayList = new ArrayList<>();
			int sum = 0;
			for (int j = i; j < nums.length; j++) {
				subArrayList.add(nums[j]);
				List<Integer> tempList = new ArrayList<>(subArrayList);
				combinationList.add(tempList);
				sum += nums[j];
				if (sum > max) {
					max = sum;
				}
			}
		}

		System.out.println(combinationList);
		return max;

	}

	/*
	 * 排列組合3層for迴圈
	 */
	public static void combination(int[] nums) {

		List<List<Integer>> combinationList = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				List<Integer> subArrayList = new ArrayList<>();
				for (int k = i; k <= j; k++) {
					subArrayList.add(nums[k]);
				}
				combinationList.add(subArrayList);
			}
		}

		System.out.println(combinationList);
	}
}
