package misc;

import java.util.Scanner;

public class SubsetsWithXorValue {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int testCase = s.nextInt();
		for (int i = 0; i < testCase; i++) {
			int n = s.nextInt();
			int k = s.nextInt();
			int[] ar = new int[n];
			for (int j = 0; j < ar.length; j++) {
				ar[j] = s.nextInt();
			}
			System.out.println(countSubset(ar, k));
		}

	}

	public static int countSubset(int[] arr, int k) {

		int max_ele = arr[0];
		for (int i = 1; i < arr.length; i++)
			if (arr[i] > max_ele)
				max_ele = arr[i];

		int m = (1 << (int) (getLog(max_ele) + 1)) - 1;

		int[][] dp = new int[arr.length + 1][m + 1];

		for (int i = 0; i <= arr.length; i++)
			for (int j = 0; j <= m; j++)
				dp[i][j] = 0;

		dp[0][0] = 1;

		for (int i = 1; i <= arr.length; i++)
			for (int j = 0; j <= m; j++)
				dp[i][j] = dp[i - 1][j] + dp[i - 1][j ^ arr[i - 1]];

		return dp[arr.length][k];

	}

	public static int log(int n) {

		return (n > 1) ? 1 + log(n / 2) : 0;
	}
	public static int getLog(int n) {
		int x = 0;
		while ((1 << x) < n) {
			x++;
		}
		if ((1 << x) > n) {
			x--;
		}
		return x;
	}
}
