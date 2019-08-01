package InternQuestDP;

import java.util.Arrays;
import java.util.Scanner;

public class Tallest_Billboard {

    public static int tallestBillboard(int[] rods) {
//    	dp[i][j] represents whether the sum of first i numbers can be j - 5000. dp[0][5000] = true.
    	
        int n = rods.length;
        int[][] dp = new int[n+1][10001];//largest sum of left at i-th rod and difference between
		//sum of left and sum of right equals to j-sum
        for (int i = 0; i <= n; i++){
            Arrays.fill(dp[i], -1);// -1 means the value could not be reached.
        }
        dp[0][5000] = 0; //it means if there  is no rods, the  largest left sum could be 0, not -1.
        for (int i = 1; i <= n; i++){
            for (int j = 0; j <= 10000; j++){
                if (j - rods[i-1] >= 0 && dp[i-1][j-rods[i-1]] != -1){//this means we will add next rod (rods[i-1] to the left, 
				//so the largest left sum should be added by rods[i-1] from previous step
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-rods[i-1]] + rods[i-1]);
                }
                if (j + rods[i-1] <=10000 && dp[i-1][j+rods[i-1]] != -1){//this means we will add next rod(rods[i-1]) to the right, 
				//so largest left sum at previous step stays at dp[i-1][j+rods[i-1]]
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j+rods[i-1]]);
                }
                if (dp[i-1][j] != -1){//this means we don't use rods[i-1] but we need ensure 
				//previous step could be reached, so we can compare.
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                }
            }
        }
	return dp[n][5000];
      }
  

	public static void main(String[] args) {

	Scanner scn = new Scanner(System.in);

		int arr[]={1,2,3,4,5,6};
		int heightboard = tallestBillboard(arr);
		System.out.println(heightboard);
	}

}

	  

