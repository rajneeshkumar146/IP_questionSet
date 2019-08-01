package InternQuestionDP;

import java.util.Scanner;

public class Minimum_Operations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t-- > 0) {
			int n = s.nextInt();
			int[] dp = new int[n + 1];
			dp[0] = dp[1] = 1;
			for (int i = 2; i <= n; i++) {
				if (i % 2 == 0)
					dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;
				else
					dp[i] = dp[i - 1] + 1;
			}
			System.out.println(dp[n]);
		}
	}
}
