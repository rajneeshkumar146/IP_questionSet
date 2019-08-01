package InternQuestionDP;

public class Minimum_four_sum_subsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int minSum(int arr[], int n) {
		int dp[] = new int[n];

		for (int i = 0; i < n; i++) {

			if (i <= 3)
				dp[i] = arr[i];
			else
				dp[i] = arr[i] + minimum(dp[i - 1], dp[i - 2], dp[i - 3], dp[i - 4]);

		}

		int min = Integer.MAX_VALUE;
		for (int i = n - 1; i >= Math.max(0, n - 4); i--)
			min = Math.min(min, dp[i]);

		return min;
	}

	public static int minimum(int a, int b, int c, int d) {
		return Math.min(Math.min(a, b), Math.min(c, d));
	}
}
