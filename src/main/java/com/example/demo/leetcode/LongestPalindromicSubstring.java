package com.example.demo.leetcode;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		String s = "babad";
//		String s = "fhuiwfhbiuqybfuybquyflevelfnqwiufqyuifgyuqfvuq";
		System.out.println(longestPalindrome(s));
	}

	public static String longestPalindrome(String s) {

		int len = s.length() - 1;
		boolean[][] dp = new boolean[len + 1][len + 1];
		Lps lps = new Lps(-1, -1, -1);
		int i = 0;
		int j = 0;

		while (j <= len) {

			System.out.printf("(%d,%d)", i, j);

			// 單個單字也是個回文
			if (i == j) {
				dp[i][j] = true;
				if (0 > lps.getLength()) {
					lps.setLength(0);
					lps.setBeginIndex(i);
					lps.setEndIndex(j);
				}
			} else { // 不是單個單字

				if (s.charAt(i) == s.charAt(j)) {

					// 相鄰
					if (j - i == 1) {
						// 相鄰無須依賴子問題的答案，直接設為true
						dp[i][j] = true;
						if (1 > lps.getLength()) {
							lps.setLength(1);
							lps.setBeginIndex(i);
							lps.setEndIndex(j);
						}
					} else {
						// 不是相鄰(中間有子字串)
						// 必須判斷中間的子字串是否是回文
						// 僅僅依賴前一輪的子問題的答案而已
						if (dp[i + 1][j - 1] == true) {
							dp[i][j] = true;
							if (j - i > lps.getLength()) {
								lps.setLength(j - i);
								lps.setBeginIndex(i);
								lps.setEndIndex(j);
							}
						}
					}

				}
			}

			// =============遍歷順序===============
			if (i == j) {
				i = 0;
				j++;
				System.out.println();
			} else {
				i++;
			}
			// ====================================
		}

		for (int k = 0; k < dp.length; k++) {
			for (int m = 0; m < dp[0].length; m++) {
				System.out.printf("dp[%d][%d]=%b ", k, m, dp[k][m]);
			}
			System.out.println();
		}

		System.out.println(lps);

		return s.substring(lps.getBeginIndex(), lps.getEndIndex() + 1);
	}
}

class Lps {

	int length;
	int beginIndex;
	int endIndex;

	public Lps(int length, int beginIndex, int endIndex) {
		super();
		this.length = length;
		this.beginIndex = beginIndex;
		this.endIndex = endIndex;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getBeginIndex() {
		return beginIndex;
	}

	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	@Override
	public String toString() {
		return "Lps [length=" + length + ", beginIndex=" + beginIndex + ", endIndex=" + endIndex + "]";
	}

}
