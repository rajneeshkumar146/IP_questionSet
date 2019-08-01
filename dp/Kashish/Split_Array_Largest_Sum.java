package InternQuestDP;

import java.util.Scanner;

public class Split_Array_Largest_Sum {
	 public static int splitArray(int[] nums, int m) {
	        if (nums.length == 1) return nums[0];
	        
	       
	        int[][] dp = new int[nums.length][m+1];
	        
	        for (int i = 0; i < nums.length; i++) {
	            for (int j = 1; j <= m; j++) {
	                dp[i][j] = Integer.MAX_VALUE;
	            }
	        }
	        
	        
	        dp[0][1] = nums[0];
	        
	        
	        for (int i=1; i<nums.length; i++){
	            dp[i][1] = dp[i-1][1] + nums[i];
	        }
	        
	        if (m == 1) return dp[nums.length-1][1];
	        
	        for (int i=1; i<nums.length; i++){
	            for (int j=2; j<=m; j++){
	                for (int k=0; k<i; k++){
	                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i][1] - dp[k][1], dp[k][j-1]));
	                }
	            }
	        }
	   
	        return dp[nums.length-1][m];
	    }

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int nums[] = {7,2,5,10,8};
		int m=2;
		System.out.println(splitArray(nums, m));
		
		

	}

}
