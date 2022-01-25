package com.example.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {

		String s = "abcabcbb";
		String s1 = "abba";

		System.out.println(lengthOfLongestSubstring(s1));

	}// end main

	public static int lengthOfLongestSubstring(String s) {

		int len = s.length();

		if (len == 0)
			return 0;

		int left = 0;
		int right = 0;
		int maxLen = -1;
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < len; i++) {

			right = i;
			char c = s.charAt(i);

			if (map.containsKey(c)) {
				int tempLeft = map.get(c) + 1;
				left = tempLeft > left ? tempLeft : left;
			}

			map.put(c, i);

			/*
			 * if (right - left + 1 > maxLen) { maxLen = right - left + 1; }
			 */
			maxLen = Math.max(maxLen, right - left + 1);

		} // end for

		return maxLen;
	}
}
