package com.example.demo.leetcode;

public class RemoveDuplicatesfromSortedArray {

	public static void main(String[] args) {
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		System.out.println(removeDuplicates(nums));
	}

	public static int removeDuplicates(int[] nums) {

		int pointer = 1;
		
		for (int idx = 1; idx < nums.length; idx++) {
			int num = nums[idx];
			if (num != nums[pointer - 1]) {
				nums[pointer] = num;
				pointer++;
			}
		}

		return pointer;

	}

}
