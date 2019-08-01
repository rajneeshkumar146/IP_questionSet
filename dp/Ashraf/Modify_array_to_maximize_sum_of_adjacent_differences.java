package InternQuestionDP;

import java.util.Scanner;

public class Modify_array_to_maximize_sum_of_adjacent_differences {
	static int maximumDifferenceSum(int arr[], int N) {
		int dp[][] = new int[N][2];

		for (int i = 0; i < N; i++)
			dp[i][0] = dp[i][1] = 0;

		for (int i = 0; i < (N - 1); i++) {
			dp[i + 1][0] = Math.max(dp[i][0], dp[i][1] + Math.abs(1 - arr[i]));
			dp[i + 1][1] = Math.max(dp[i][0] + Math.abs(arr[i + 1] - 1), dp[i][1] + Math.abs(arr[i + 1] - arr[i]));
		}

		return Math.max(dp[N - 1][0], dp[N - 1][1]);
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int N = scn.nextInt();
			int arr[] = new int[N];

			for (int i = 0; i < N; i++)
				arr[i] = scn.nextInt();
			System.out.println(maximumDifferenceSum(arr, N));
		}
	}
}
