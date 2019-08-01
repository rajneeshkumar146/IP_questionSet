package InternQuestDP;

import java.util.Scanner;

public class Shortest_Uncommon_Subsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int m = scn.nextInt();
			int n = scn.nextInt();
			String s1 = scn.next();
			String s2 = scn.next();
			int length = ShortUnSub(s1, s2, m, n);
			System.out.println(length);
		}

	}

	private static int ShortUnSub(String s1, String s2, int m, int n) {

		int MAX = 10000;
		int dp[][] = new int[s1.length() + 1][s2.length() + 1];
		char[] st1 = s1.toCharArray();
		char[] st2 = s2.toCharArray();
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;

		}
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = MAX;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				boolean found = false;
				for (int k = j - 1; k >= 0; k--) {
					if (st1[i - 1] == st2[k]) {

						found = true;
						dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][k] + 1);
						break;
					}
				}
				if (!found) {
					dp[i][j] = 1;
				}
			}
		}

		return dp[m][n]>=MAX?-1:dp[m][n];

	}
}
