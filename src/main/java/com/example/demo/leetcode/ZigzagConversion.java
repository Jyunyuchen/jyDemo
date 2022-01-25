package com.example.demo.leetcode;

/**
 * 6. Zigzag Conversion
 * 
 * @author jy
 *
 */
public class ZigzagConversion {

	public static void main(String[] args) {
		String s = "AB";
		int numRows = 1;
		System.out.println(convert(s, numRows));
	}

	public static String convert(String s, int numRows) {

		char[] charArray = s.toCharArray();
		StringBuilder[] stringBuilder = new StringBuilder[numRows];

		for (int i = 0; i < numRows; i++) {
			stringBuilder[i] = new StringBuilder();
		}

		int j = 0;
		boolean decFlag = false;
		for (int i = 0; i < charArray.length; i++) {
			stringBuilder[j].append(charArray[i]);
			// System.out.print(j + " -> ");

			// ================j的走法===================
			if (j == numRows - 1 || decFlag) {
				j--;
				decFlag = true;

				if (j < 0) {
					j = 0;
				}

				if (j == 0) {
					decFlag = false;
				}
			} else {
				j++;
			}
			// ================j的走法===================
		}

		for (int i = 1; i < numRows; i++) {
			stringBuilder[0].append(stringBuilder[i]);
		}

		return stringBuilder[0].toString();

	}

}
