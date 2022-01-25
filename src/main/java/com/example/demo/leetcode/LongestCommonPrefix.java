package com.example.demo.leetcode;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs = { "flower", "flow", "flight" };
		//String[] strs = { "ab", "a" };
		
	
//		String commonPrefix = strs[0];
//		System.out.println(strs[1].startsWith(commonPrefix));
//		System.out.println(commonPrefix.substring(0, commonPrefix.length()));
	

		System.out.println(longestCommonPrefix(strs));
	}

	public static String longestCommonPrefix(String[] strs) {

		String commonPrefix = strs[0];

		for (int i = 1; i < strs.length; i++) {

			StringBuilder sb = new StringBuilder();

			for (int j = 0; j < commonPrefix.length(); j++) {
				if (j > strs[i].length() - 1) {
					commonPrefix = sb.toString();
					break;
				}

				if (commonPrefix.charAt(j) == strs[i].charAt(j)) {
					sb.append(commonPrefix.charAt(j));
				} else {
					commonPrefix = sb.toString();
					break;
				}
			}
		}

		return commonPrefix;

	}
}
