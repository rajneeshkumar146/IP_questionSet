
public class BestTimetoBuyandSellStock3 {

	static int maxProfit(int price[], int n) {
		int profit[] = new int[n];
		for (int i = 0; i < n; i++)
			profit[i] = 0;

		// maximum profit with only one transaction allowed
		int max_price = price[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			// max_price has maximum of price[i..n-1]
			if (price[i] > max_price)
				max_price = price[i];

			profit[i] = Math.max(profit[i + 1], max_price - price[i]);
		}

		
//		  maximum profit with two transactions allowed 
//		  After this loop,profit[n-1] contains the result
		 
		int min_price = price[0];
		for (int i = 1; i < n; i++) {
			// min_price is minimum price in price[0..i]
			if (price[i] < min_price)
				min_price = price[i];

			profit[i] = Math.max(profit[i - 1], profit[i] + (price[i] - min_price));
		}
		int result = profit[n - 1];
		return result;
	}

}
