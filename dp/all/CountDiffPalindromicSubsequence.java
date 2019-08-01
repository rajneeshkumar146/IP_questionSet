
public class CountDiffPalindromicSubsequence {
	public static void countPalindromicSubsequence(String s) {
		int[][] dp = new int[s.length()][s.length()];
		for (int gap = 0; gap <= s.length() - 1; gap++) {
			for (int i = 0, j = i + gap; j <= dp[0].length - 1; i++, j++) {
				if (gap == 0)
					dp[i][j] = 1;
				else if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + 1;
				} else {
					dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
				}
			}
		}
		System.out.println(dp[0][dp[0].length - 1]);
	}
}
