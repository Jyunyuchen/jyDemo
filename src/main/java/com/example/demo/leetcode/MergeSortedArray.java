package com.example.demo.leetcode;

import java.util.Arrays;

public class MergeSortedArray {

	public static void main(String[] args) {
//		int[] num1 = { 1, 2, 3, 0, 0, 0 };
//		int m = 3;
//		int[] num2 = { 2, 5, 6 };
//		int n = 3;

		int[] num1 = { 0 };
		int m = 0;
		int[] num2 = { 1 };
		int n = 1;

		merge(num1, m, num2, n);
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {

		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;

		while (i >= 0 && j >= 0) {
			if (nums1[i] < nums2[j]) {
				nums1[k] = nums2[j];
				k--;
				j--;
			} else {
				nums1[k] = nums1[i];
				k--;
				i--;
			}
		}

		while (j >= 0) {
			nums1[k] = nums2[j];
			k--;
			j--;
		}

		System.out.println(Arrays.toString(nums1));
	}
}
