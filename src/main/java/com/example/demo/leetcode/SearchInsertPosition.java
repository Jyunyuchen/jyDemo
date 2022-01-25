package com.example.demo.leetcode;

public class SearchInsertPosition {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5, 6 };
		int target = 0;

//		int[] nums = { 1, 3 };
//		int target = 0;

		System.out.println(searchInsert(nums, target));
	}

	public static int searchInsert(int[] nums, int target) {

		int min = 0;
		int max = nums.length - 1;
		int middle = (min + max) / 2;

		while (true) {

			if (max < min) {
				return max + 1;
			}

			if (nums[middle] < target) {
				min = middle + 1;
			} else if (nums[middle] > target) {
				max = middle - 1;
			} else if (nums[middle] == target) {
				return middle;
			}

			middle = (min + max) / 2;

		} // end while

	}
}
