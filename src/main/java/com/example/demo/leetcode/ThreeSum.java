package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {

		// int[] nums = { -1, 0, 1, 2, -1, -4 };
		int[] nums = { -2, 0, 0, 2, 2 };
		System.out.println(threeSum(nums));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int len = nums.length;
		if (len < 3) {
			return result;
		}

		Arrays.sort(nums);

		// for all number that can be the 1st number of triplet
		for (int i = 0; i < len - 1; i++) {
			int firstNumber = nums[i];

			// skip all duplicated first number
			if (i == 0 || firstNumber != nums[i - 1]) {

				int leftIndex = i + 1;
				int rightIndex = len - 1;
				int twoSumTarget = 0 - firstNumber;

				// try to find two numbers that sum up to twoSumTarget
				while (leftIndex < rightIndex) {
					int twoSum = nums[leftIndex] + nums[rightIndex];
					if (twoSum == twoSumTarget) {
						// one valid triplet found!!
						result.add(Arrays.asList(firstNumber, nums[leftIndex], nums[rightIndex]));
						// skip duplicated nums[leftIndex]
						while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex + 1]) {
							leftIndex++;
						}
						// skip duplicated nums[rightIndex]
						while (leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex - 1]) {
							rightIndex--;
						}
						// move to next non-duplicates
						leftIndex++;
						rightIndex--;
					} else if (twoSum < twoSumTarget) {
						// move left towards right to
						// make twoSum larger to get closer to twoSumTarget
						leftIndex++;
					} else {
						rightIndex--;
					}
				}

			}
		}

		return result;
	}

	public static List<List<Integer>> threeSum1(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();

		if (nums == null || nums.length < 3) {
			return ans;
		}

		Arrays.sort(nums);

		int len = nums.length;
		int left = 0;
		int right = 1;

		for (int i = 0; i < len; i++) {

			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			if (i + 1 < len - 1) {
				left = i + 1;
			}

			if (right > 0) {
				right = len - 1;
			}

			while (left < right) {

				int triplet = nums[i] + nums[left] + nums[right];

				if (triplet == 0) {
					ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
					if (left + 1 < len) {
						left++;
						while (left + 1 < len && nums[left] == nums[left - 1]) {
							left++;
						}
					}
					if (right - 1 > 0) {
						right--;
						while (right - 1 > 0 && nums[right] == nums[right + 1]) {
							right--;
						}
					}

				} else if (triplet < 0) {
					if (left + 1 < len) {
						left++;
					}
				} else if (triplet > 0) {
					if (right - 1 > 0) {
						right--;
					}
				}

			} // end while

		} // end for

		return ans;

	}
}
