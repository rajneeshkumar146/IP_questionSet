package InternQuestionDP;

import java.util.Scanner;

public class Minimum_steps_to_minimize_n_as_per_given_condition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			System.out.println(count_min(n));
		}
	}

	public static int count_min(int n) {
		int[] dp = new int[n + 1];
		dp[n] = 0;
		if (n >= 1)
			dp[n - 1] = 1;

		for (int i = n - 2; i >= 1; i--) {
			dp[i] = dp[i + 1] + 1;
			if (2 * i <= n)
				dp[i] = Math.min(dp[i], dp[2 * i] + 1);
			if (3 * i <= n)
				dp[i] = Math.min(dp[i], dp[3 * i] + 1);
			// dp[i] = dp[i] +1;
			// System.out.println(i +": "+dp[i]);
		}
		return dp[1];
	}
}
