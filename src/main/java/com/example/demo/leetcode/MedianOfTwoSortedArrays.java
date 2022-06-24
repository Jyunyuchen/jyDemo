package com.example.demo.leetcode;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {

        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        System.out.println(Arrays.toString(mergeTwoSortArray(nums1, nums2)));
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        double[] mergeArray = mergeTwoSortArray(nums1, nums2);
        double median;

        if (mergeArray.length % 2 == 0) {
            median = (mergeArray[mergeArray.length / 2] + mergeArray[mergeArray.length / 2 - 1]) / 2;

        } else {
            median = mergeArray[mergeArray.length / 2];
        }

        return median;
    }

    public static double[] mergeTwoSortArray(int[] nums1, int[] nums2) {

        double[] mergeArray = new double[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] <= nums2[j]) {
                mergeArray[k] = nums1[i];
                i++;
            } else {
                mergeArray[k] = nums2[j];
                j++;
            }

            k++;
        }

        while (i < nums1.length) {
            mergeArray[k] = nums1[i];
            i++;
            k++;
        }

        while (j < nums2.length) {
            mergeArray[k] = nums2[j];
            j++;
            k++;
        }

        return mergeArray;
    }
}
