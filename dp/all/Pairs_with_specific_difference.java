package InternQuestionDP;

import java.util.Arrays;
import java.util.Scanner;

public class Pairs_with_specific_difference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = scn.nextInt();
			}
			int k = scn.nextInt();
			Arrays.sort(a);
			int dp[] = new int[n];

			dp[0] = 0;

			if (n > 1) {
				dp[1] = 0;
				if (a[1] - a[0] < k)
					dp[1] = a[1] + a[0];
			}
			for (int i = 2; i < a.length; i++) {
				dp[i] = dp[i - 1];
				if (a[i] - a[i - 1] < k)
					dp[i] = Math.max(dp[i], dp[i - 2] + a[i] + a[i - 1]);
			}
//			for (int v : dp) {
//				System.out.print(v + " ");
//			}
			System.out.println(dp[n - 1]);
		}
	}

}
