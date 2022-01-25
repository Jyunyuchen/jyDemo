package com.example.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	public static void main(String[] args) {
		System.out.println(romanToInt("D"));
	}

	public static int romanToInt(String s) {
		
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		char left = 0;
		char right = 0;
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			left = s.charAt(i);
			if (i + 1 < s.length()) {
				right = s.charAt(i + 1);
			}
			
			if( s.length() == 1) {
				right = left;
			}

			if (map.get(left) > map.get(right)) {
				sum += map.get(left);
			} else if (map.get(left) < map.get(right)) {
				sum += -map.get(left);
			}

			if (left == right) {
				sum += map.get(left);
			}

		}

		return sum;

	}
}
