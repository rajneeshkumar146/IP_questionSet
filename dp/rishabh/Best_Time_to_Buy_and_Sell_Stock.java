
public class Best_Time_to_Buy_and_Sell_Stock {

    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            // New min would be the best day to buy for selling in the subsequent days 
        	if (prices[i] < minprice)
                minprice = prices[i];
        	//Profit updated when a greater profit
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}
