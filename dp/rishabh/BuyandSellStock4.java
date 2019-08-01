
public class BuyandSellStock4 {

	static int maxProfit(int[] price, int n, int k) {

		// profit[t][i] stores
		// maximum profit using
		// atmost t transactions up
		// to day i (including day i)
		int[][] profit = new int[k + 1][n + 1];

		// For day 0, you can't
		// earn money
		for (int i = 0; i <= k; i++)
			profit[i][0] = 0;

		// profit is 0 in 0 transactions
		for (int j = 0; j <= n; j++)
			profit[0][j] = 0;

		// k represents transaction number
		for (int i = 1; i <= k; i++) {
			
			for (int j = 1; j < n; j++) {
				int max_so_far = 0;

				for (int m = 0; m < j; m++)
					max_so_far = Math.max(max_so_far, price[j] - price[m] + profit[i - 1][m]);

				profit[i][j] = Math.max(profit[i][j - 1], max_so_far);
			}
		}

		return profit[k][n - 1];
	}

}
