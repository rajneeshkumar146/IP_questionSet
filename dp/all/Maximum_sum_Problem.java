package InternQuestionDP;

import java.util.Arrays;
import java.util.Scanner;

public class Maximum_sum_Problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();

			int dp[] = new int[n + 1];
			Arrays.fill(dp, -1);
			System.out.println(maxSum(dp, n));
		}
	}

	public static int maxSum(int[] dp, int n) {
		if (dp[n] != -1) {
			return dp[n];
		}
		if (n <= 6) {
			return dp[n] = n;
		}
		return dp[n] = Math.max(n, maxSum(dp, n / 2) + maxSum(dp, n / 3) + maxSum(dp, n / 4));
	}
}
