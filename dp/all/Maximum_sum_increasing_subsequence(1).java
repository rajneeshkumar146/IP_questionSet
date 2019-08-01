package InternQuestionDP;

import java.util.Scanner;

public class Maximum_sum_increasing_subsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			int a[] = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = scn.nextInt();

			int dp[] = new int[n];

			for (int i = 0; i < n; i++) {
				dp[i] = a[i];
			}

			for (int i = 1; i < n; i++) {
				for (int j = 0; j < i; j++) {

					if (a[i] > a[j]) {
						if (dp[i] < dp[j] + a[i]) {
							dp[i] = dp[j] + a[i];
						}
					}
				}
			}
			int max = Integer.MIN_VALUE;

			for (int v : dp) {
				max = Math.max(max, v);
			}
			System.out.println(max);
		}
	}

}
