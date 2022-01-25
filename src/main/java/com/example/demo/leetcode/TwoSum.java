package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {

		int[] nums = { 2, 11, 7, 15 };
		int target = 26;

		System.out.println(Arrays.toString(twoSum(nums, target)));

	} // end main

	public static int[] twoSum(int[] nums, int target) {

		Map<Integer, Integer> Map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {

			if (Map.containsKey(nums[i])) {
				return new int[] { Map.get(nums[i]), i };
			}
			int minus = target - nums[i];
			Map.put(minus, i);
			
		}

		return new int[0];

	}

}
