
public class BurstBalloons {
    Integer[][] dp = null;
public int maxCoins(int[] nums) {
	int n = nums.length;
	dp = new Integer[n][n];
	return maxCoins(nums, 0, n - 1);
}
private int maxCoins(int[] n, int i, int j) {
	if (i > j)
		return 0;
	if (dp[i][j] != null)
		return dp[i][j];
	dp[i][j] = 0;
	for (int k = i; k <= j; k++) {
		int prod = n[k];
		if (i - 1 >= 0)
			prod *= n[i - 1];
		if (j + 1 < n.length)
			prod *= n[j + 1];
		dp[i][j] = Math.max(dp[i][j], maxCoins(n, i, k - 1) + prod + maxCoins(n, k + 1, j));
	}
	return dp[i][j];
}
}
