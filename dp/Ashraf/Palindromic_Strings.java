package InternQuestionDP;

import java.util.Scanner;

public class Palindromic_Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			int k = scn.nextInt();
			String s = scn.next();
			String s1 = new StringBuilder(s).reverse().toString();
			int[][] dp = new int[n + 1][n + 1];
			for (int i = 0; i <= n; i++) {
				for (int j = 0; j <= n; j++) {
					if (i == 0 || j == 0)
						dp[i][j] = 0;
					else if (s.charAt(i - 1) == s1.charAt(j - 1))
						dp[i][j] = dp[i - 1][j - 1] + 1;
					else
						dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
			for (int[] c : dp) {
				for (int v : c) {
					System.out.print(v + " ");
				}
				System.out.println();
			}
			int rem = n - dp[n][n];
			if (rem <= k)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}