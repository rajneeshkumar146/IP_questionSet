package InternQuestionDP;

import java.util.Scanner;

public class Minimum_Deletions {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {

			String str = scn.next();
			int n = str.length();
			int dp[][] = new int[n][n];
			for (int g = 0; g < n; g++) {
				for (int i = 0, j = g; j < n; j++, i++) {
					if (i == j) {
						dp[i][j] = 1;
					} else if (str.charAt(i) == str.charAt(j)) {
						dp[i][j] = 2 + dp[i + 1][j - 1];
					} else {
						dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
					}
				}
			}
			System.out.println(n - dp[0][n - 1]);
		}
	}
}