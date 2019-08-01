package InternQuestionDP;

import java.util.Arrays;
import java.util.Scanner;

public class Number_of_permutation_with_K_inversions {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[][] dp = new int[n + 1][k + 1];
			for (int[] i : dp)
				Arrays.fill(i, -1);
			System.out.println((findPerm(n, k, dp)));
		}
	}

	static int mod = (int) (1e9 + 7);

	static int findPerm(int n, int k, int dp[][]) {
		if (n == 0)
			return dp[n][k] = 0;
		if (k == 0)
			return dp[n][k] = 1;
		if (dp[n][k] != -1)
			return dp[n][k];
		int ans = 0;
		for (int i = 0; i <= k; i++)
			if (i < n) {
				ans += findPerm(n - 1, k - i, dp);
				ans %= mod;
			}
		return dp[n][k] = ans;
	}

}