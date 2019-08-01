package InternQuestDP;

import java.util.Scanner;

public class Profitable_Schemes {
	static int mod=(int) (1e9+7);
		public static int profitableSchemes(int G, int P, int[] group, int[] profit) {
			
	        int[][] dp = new int[G + 1][P + 1];
	        dp[0][0] = 1;
	        for (int k = 0; k < group.length; k++) {
	            int g = group[k ];
	            int p = profit[k];
	            for (int i = G; i >= g; i--) {
	                for (int j = P; j >= 0; j--) {
	                    dp[i][j] = (dp[i][j] + dp[i - g][Math.max(0, j - p)])%mod;
	                }
	            }
	        }
	        for(int i=0;i<dp.length;i++){
	        	for(int j=0;j<dp[0].length;j++){
	        		System.out.print(dp[i][j]+" ");
	        	}
	        	System.out.println();
	        }
	        int sum = 0;                                                       
	        for(int i = 0; i <= G; i++){
	            sum = (sum + dp[i][P])%mod;
	        }
	        return sum;
	    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int G = 8;
		int P = 5;
		int group[] = { 2, 3,5 };
		int profit[] = { 6,7,3 };
	

		int netprofit = profitableSchemes(G, P, group, profit);
		System.out.println(netprofit);

	}

}
