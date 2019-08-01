package InternQuestionDP;

import java.util.Scanner;

public class Minimum_Partition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			int a[] = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = scn.nextInt();
			System.out.println(findMinSumPartition(a, n));
		}
	}

	static int findMinSumPartition(int arr[], int n) {

		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += arr[i];

		boolean dp[][] = new boolean[n + 1][sum + 1];

		for (int i = 0; i <= n; i++)
			dp[i][0] = true;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				dp[i][j] = dp[i - 1][j];

				if (arr[i - 1] <= j)
					dp[i][j] |= dp[i - 1][j - arr[i - 1]];
			}
		}

		int diff = Integer.MAX_VALUE;

		for (int j = sum / 2; j >= 0; j--) {
			if (dp[n][j] == true) {
				diff = sum - 2 * j;
				break;
			}
		}
		return diff;
	}
}
