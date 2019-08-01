package Strings;

import java.util.Scanner;

public class Pep_JavaIP_3Strings_99CountBinaryStringsWithKAdjacentOnes {
	/* What :Count all binary strings of length n where at most k adjacent ones are present
	 * How : Create a dp , which stores length of string vs no of adjacent ones vs ending with zero
	 *			or one.
	 * Why :Strings can only end with zero or one.
	 *			ending with zero =  (n-1 len, k ones,end at 0)  or (n-1 len, k ones,end at 1)
	 *			ending with one =  (n-1 len, k ones,end at 0)  or (n-1 len, k-1 ones,end at 1)
	 * 			Count of adjacent ones changes only when we append 1's to strings ending with 1.
	 *
	*/
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();

		System.out.println(count_seq(n, k));

	}

	public static int count_seq(int n, int k) {
		// dp[i][j][l] => represents number of subsequences formed from i digits
		// with j adjacent 1's ending with l digit.
		int[][][] dp = new int[n + 1][k + 1][2];
		dp[1][0][0] = 1;
		dp[1][0][1] = 1;

		for (int i = 2; i <= n; i++) {
			// number of adjacent 1's can not exceed i-1
			for (int j = 0; j < i && j <= k; j++) {

				// only two equations.
				// generating sequences ending with 1 and 0 by adding 0 and 1 respectively.

				dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1];
				dp[i][j][1] = dp[i - 1][j][0];

				/*can append only when adjacent 1 count is >=1*/
				if (j - 1 >= 0)
					dp[i][j][1] += dp[i - 1][j - 1][1];
			}
		}
		// return the total strings ending with 0 and 1 containing k 1's.
		return dp[n][k][0] + dp[n][k][1];
	}

}

/*
Test cases:
	5 2
	----------------------
	6

	6 4
	----------------------
	2


	10 4
	----------------------
	116

	Source: https://www.geeksforgeeks.org/count-binary-strings-k-times-appearing-adjacent-two-set-bits/
	*/
