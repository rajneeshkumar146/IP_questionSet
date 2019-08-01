package InternQuestionDP;

public class Paint_Fence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(CountWays(4, 5));
	}

	public static int CountWays(int n, int k) {
		int[] dp = new int[n + 1];
		dp[1] = k;
		int same = 0;
		int diff = k;
		for (int i = 2; i <= n; i++) {
			same = diff;
			diff = dp[i - 1] * (k - 1);
			dp[i] = same + diff;
		}
		return dp[n];
	}
}
