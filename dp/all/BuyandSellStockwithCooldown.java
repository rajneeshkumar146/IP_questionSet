
public class BuyandSellStockwithCooldown {

	// Problem is solved wit state assignments
	// s0 represents state when a stock can be bought(i.e cooldown is over)
	// s1 represents state when the stock is bought(i.e transaction is ongoing)
	// s2 represents state when the stock is sold(i.e cooldown is started)
	public int maxProfit(int[] prices) {
	    if(prices.length == 0){
	        return 0;
	    }
	    int s0 = 0, s0prev = 0;
	    int s1 = 0, s1prev=-prices[0];
	    int s2 = 0, s2prev=Integer.MIN_VALUE;
	    for(int p : prices){
	        s0 = Math.max(s0prev,s2prev);
	        s1 = Math.max(s1prev,s0prev-p);
	        s2 = Math.max(s2prev,s1prev+p);
	        s0prev=s0;
	        s1prev=s1;
	        s2prev=s2;
	    }
	    return Math.max(s0,s2);
	}
}