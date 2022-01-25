package com.example.demo.leetcode;

import java.util.Arrays;

/*
 * 27. Remove Element
 */
public class RemoveElement {

	public static void main(String[] args) {
		int[] nums = { 3, 2, 2, 3 };
		int val = 2;
		System.out.println(removeElement(nums, val));
	}

	public static int removeElement(int[] nums, int val) {

		int reserved = 0;
	
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[reserved] = nums[i];
				reserved++;
			}
		}

		return reserved;
	}

}
