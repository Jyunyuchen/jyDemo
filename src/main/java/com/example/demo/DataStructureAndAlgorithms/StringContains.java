package com.example.demo.DataStructureAndAlgorithms;

public class StringContains {

	public static void main(String[] args) {
		String sampleStr = "This is a String contains Example";
		String containsStr = "T";

		char[] sampleStrArray = sampleStr.toCharArray();
		char[] containsStrArray = containsStr.toCharArray();

		int j = 0;
		boolean isContain = false;
		for (int i = 0; i < sampleStrArray.length; i++) {

			if (sampleStrArray[i] == containsStrArray[j]) {
				if (j == containsStrArray.length-1) {
					isContain = true;
					break;
				}
				j++;
			}else {
				j = 0;
			}

		}
		
		System.out.println(isContain);

	}

}
