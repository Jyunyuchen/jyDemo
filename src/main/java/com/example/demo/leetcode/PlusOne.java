package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 66. Plus One
 * 
 * @author jy
 *
 */
public class PlusOne {

	public static void main(String[] args) {
		int[] digits = { 9, 9 };
		System.out.println(Arrays.toString(plusOne(digits)));
	}

	public static int[] plusOne(int[] digits) {

		List<Integer> numList = new ArrayList<>();
		int carry = 1;
		for (int i = digits.length - 1; i >= 0; i--) {

			int last = digits[i];
			last = last + carry;
			carry = last / 10;
			int remainder = last % 10;
			numList.add(0, remainder);

			// 如果沒有下一個了
			if (carry > 0 && i == 0) {
				numList.add(0, carry);
			}
		}

		return numList.stream().mapToInt(Integer::intValue).toArray();

	}
}
