package dp;

public class Minimum_ascii_delete_for_two_substrings {

	public static void main(String[] args) {
		// Scanner scn = new scanner(System.in);
		
		System.out.println(func("sea", "eat"));

	}

	public static int func(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		for (int i = s1.length() - 1; i >= 0; i--) {
			dp[i][s2.length()] = dp[i + 1][s2.length()] + s1.codePointAt(i);

		}
		for (int i = s2.length() - 1; i >= 0; i--) {
			dp[s1.length()][i] = dp[s1.length()][i + 1] + s2.codePointAt(i);
		}
		for (int i = s1.length() - 1; i >= 0; i--) {
			for (int j = s2.length() - 1; j >= 0; j--) {
				if (s1.charAt(i) == s2.charAt(j)) {
					dp[i][j] = dp[i + 1][j + 1];// no nuksaan of ascii
				} else {
					dp[i][j] = Math.min(dp[i + 1][j] + s1.codePointAt(i), dp[i][j + 1] + s2.codePointAt(j));
				}
			}
		}
		return dp[0][0];
	}
}
