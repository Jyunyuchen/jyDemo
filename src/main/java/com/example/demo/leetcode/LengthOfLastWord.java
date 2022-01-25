package com.example.demo.leetcode;

/**
 * 58. Length of Last Word
 * 
 * @author jy
 *
 */
public class LengthOfLastWord {

	public static void main(String[] args) {

		  String s = "   fly me   to   the moon  ";
		  System.out.println(lengthOfLastWord(s));
		 
	}

	public static int lengthOfLastWord(String s) {

		s = s.trim();

		int lastWordLength = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if (c != ' ') {
				lastWordLength++;
			} else {
				return lastWordLength;
			}
		}

		return lastWordLength;
	}

}
