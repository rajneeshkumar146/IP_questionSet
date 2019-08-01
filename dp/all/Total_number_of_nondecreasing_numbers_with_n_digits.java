package InternQuestDP;

import java.util.Scanner;

public class Total_number_of_nondecreasing_numbers_with_n_digits {
	static long countNonDecreasing(int n) {
		long dp[][] = new long[10][n + 1];
		for (int i = 0; i < 10; i++) {
			dp[i][1] = 1;
		}
		for (int digit = 0; digit <= 9; digit++) {
			for (int len = 2; len <= n; len++) {
				for (int x = 0; x <= digit; x++)
					dp[digit][len] += dp[x][len - 1];
			}
		}
		long ans = 0;
		for (int i = 0; i < 10; i++)
			ans += dp[i][n];
		return ans;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			System.out.println(countNonDecreasing(n));
		}
	}

}
