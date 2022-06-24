package com.example.demo.leetcode;

import org.hibernate.query.criteria.internal.path.MapAttributeJoin;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//        System.out.println(maxAreaBruteForce(height));
          System.out.println(maxAreaTwoPointer(height));

    }

    public static int maxAreaTwoPointer(int[] height) {

        int maxArea = -1;
        int leftPointer = 0;
        int rightPointer = height.length - 1;

        while (rightPointer > leftPointer) {
            maxArea = Math.max(
                    maxArea,
                    (rightPointer - leftPointer) * Math.min(height[leftPointer], height[rightPointer])
            );

            if (height[leftPointer] > height[rightPointer]) {
                rightPointer--;
            } else {
                leftPointer++;
            }

        }

        return maxArea;
    }

    public static int maxAreaBruteForce(int[] height) {

        int maxArea = -1;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxArea = Math.max(
                        maxArea,
                        (j - i) * Math.min(height[i], height[j])
                );
            }
        }

        return maxArea;
    }
}
