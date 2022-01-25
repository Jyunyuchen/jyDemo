package com.example.demo.leetcode;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		String s = "({})";
		System.out.println(isValid(s));
	}

	public static boolean isValid(String s) {

		// ({})
		String[] sArray = s.split("");
		Stack<String> stack = new Stack<String>();

		for (int i = 0; i < sArray.length; i++) {

			if (sArray[i].equals("(") || sArray[i].equals("{") || sArray[i].equals("[")) {
				stack.push(sArray[i]);
			} else {
				if (stack.isEmpty())
					return false;

				String peekOpenBracket = stack.peek();
				if ((peekOpenBracket.equals("(") && sArray[i].equals(")"))
						|| (peekOpenBracket.equals("{") && sArray[i].equals("}"))
						|| (peekOpenBracket.equals("[") && sArray[i].equals("]"))) {
					stack.pop();
				} else {
					return false;
				}
			}

		} // end for

		return stack.isEmpty();

	}
}
