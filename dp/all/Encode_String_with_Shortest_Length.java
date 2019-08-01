package InternQuestDP;

import java.util.Scanner;

public class Encode_String_with_Shortest_Length {
	public static String encode(String s) {
		if (s == null || s.length() <= 4)
			return s;

		int len = s.length();

		String[][] dp = new String[len][len];

		// iterate all the length, stay on the disgnose of the dp matrix
		for (int gap = 0; gap < len; gap++) {
			for (int i = 0, j = i + gap; j < len; i++, j++) {
				String substr = s.substring(i, j + 1);
				dp[i][j] = substr;
				if (gap < 4)
					continue;

				for (int k = i; k < j; k++) {
					if (dp[i][k].length() + dp[k + 1][j].length() < dp[i][j].length()) {
						dp[i][j] = dp[i][k] + dp[k + 1][j];
					}
				}

				String pattern = kmp(substr);
				if (pattern.length() == substr.length()) {
					continue;
				} // no repeat pattern found
				String patternEncode = substr.length() / pattern.length() + "[" + dp[i][i + pattern.length() - 1] + "]";
				if (patternEncode.length() < dp[i][j].length()) {
					dp[i][j] = patternEncode;
				}
			}
		}

		return dp[0][len - 1];
	}

	private static String kmp(String s) {
		int len = s.length();
		int[] KMP = new int[len];

		int j = 0;
		KMP[0] = 0;
		for (int i = 1; i < len; i++) {
			while (j > 0 && s.charAt(i) != s.charAt(j)) {
				j = KMP[j - 1];
			}
			if (j == 0) {
				KMP[i] = 0;
			}
			if (s.charAt(i) == s.charAt(j)) {
				KMP[i] = ++j;
			}

		}

		int patternLen = len - KMP[len - 1];
		if (patternLen != len && len % patternLen == 0) {
			return s.substring(0, patternLen);
		} else {
			return s;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

	}

}
