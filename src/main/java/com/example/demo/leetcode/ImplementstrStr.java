package com.example.demo.leetcode;

import java.util.Arrays;

public class ImplementstrStr {

	public static void main(String[] args) {
		String haystack = "mississippi";
		String needle = "issip";
		System.out.println(haystack);
		System.out.println(needle);
		System.out.println(strStr_bruteForce(haystack, needle));
	}

	public static int strStr_bruteForce(String haystack, String needle) {

		String[] haystackArr = haystack.split("");
		String[] needleArr = needle.split("");

		if (haystackArr[0].equals("") && needleArr[0].equals("")) {
			return 0;
		} else if (!haystackArr[0].equals("") && needleArr[0].equals("")) {
			return 0;
		} else if (haystackArr[0].equals("") && !needleArr[0].equals("")) {
			return -1;
		}

		int start = 0;
		boolean flag = false;
		int j = 0;
		int i = 0;

		for (; i < haystackArr.length; i++) {
			
			if (flag && j + 1 < needleArr.length) {
				//兩個字串匹配則+1，往下一個開始比較是否匹配
				j++;
			}
			for (; j < needleArr.length; j++) {
				if (!haystackArr[i].equals(needleArr[j])) {
					
					//進入匹配後匹配失敗,i回到第一次匹配字元的位置
					if(flag) {
						i = start;
					}
					flag = false;
					j = 0;
					break;
				} else {

					// 第一次進入匹配
					if (!flag) {
						start = i;
					}

					if (j == needleArr.length - 1) {
						return start;
					}
					flag = true;
					break;
				}
			}
		}

		return -1;

	}

}
