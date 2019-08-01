package InternQuestDP;

import java.util.Scanner;

public class Regular_Expression_Matching {
	public static boolean isMatch(String s, String p) {
		int m = s.length();
		int n = p.length();
		char[] ss = s.toCharArray();
		char[] pp = p.toCharArray();
		boolean[][] dp = new boolean[m + 1][n + 1];
		for (int i = 0; i <= m; ++i) {
			for (int j = 0; j <= n; ++j) {
				if (i == 0 && j == 0) {
					dp[i][j] = true;
					continue;
				}
				if (j == 0) {
					continue;
				}
				if (pp[j - 1] != '*') {
					dp[i][j] = i > 0 && dp[i - 1][j - 1] && (ss[i - 1] == pp[j - 1] || pp[j - 1] == '.');
				} else {
					dp[i][j] = (j > 1 && dp[i][j - 2])
							|| (i > 0 && j > 1 && (pp[j - 2] == ss[i - 1] || pp[j - 2] == '.') && (dp[i - 1][j]));
				}
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String text = scn.next();
		String pattern = scn.next();
		boolean result = isMatch(text, pattern);
		System.out.println(result);

	}

}
