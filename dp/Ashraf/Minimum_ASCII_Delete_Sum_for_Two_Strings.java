package InternQuestionDP;

public class Minimum_ASCII_Delete_Sum_for_Two_Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minimumDeleteSum(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m + 1][n + 1];

		for (int k = 1; k <= n; k++)
			dp[0][k] = dp[0][k - 1] + s2.charAt(k - 1);

		for (int k = 1; k <= m; k++)
			dp[k][0] = dp[k - 1][0] + s1.charAt(k - 1);

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {

				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					int left = dp[i][j - 1] + s2.charAt(j - 1);
					int top = dp[i - 1][j] + s1.charAt(i - 1);
					dp[i][j] = Math.min(left, top);
				}
			}
		}
		return dp[m][n];
	}
}
