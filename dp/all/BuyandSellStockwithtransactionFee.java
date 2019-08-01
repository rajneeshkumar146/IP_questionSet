
public class BuyandSellStockwithtransactionFee {

	public int maxProfit(int[] prices, int fee) {
	    int sell = 0, buy = -prices[0], maxSell = 0;
	    for(int i = 1; i < prices.length;i++){
	        sell = Math.max(sell, buy+prices[i]-fee);//sell
	        buy = Math.max(buy, sell-prices[i]);//buy
	        maxSell = Math.max(sell, maxSell);
	    }
	    return maxSell;
	}
}
