package InternQuestDP;

import java.util.Arrays;
import java.util.Scanner;

public class Target_Sum {
	   int count = 0;
	   public static int findTargetSumWays(int[] nums, int S) {
	        int[][] memo = new int[nums.length][2001];
	        for (int[] row: memo)
	            Arrays.fill(row, Integer.MIN_VALUE);
	        return calculate(nums, 0, 0, S, memo);
	    }
	    public static int calculate(int[] nums, int i, int sum, int S, int[][] memo) {
	        if (i == nums.length) {
	            if (sum == S)
	                return 1;
	            else
	                return 0;
	        } else {
	            if (memo[i][sum + 1000] != Integer.MIN_VALUE) {
	                return memo[i][sum + 1000];
	            }
	            int add = calculate(nums, i + 1, sum + nums[i], S, memo);
	            int subtract = calculate(nums, i + 1, sum - nums[i], S, memo);
	            memo[i][sum + 1000] = add + subtract;
	            return memo[i][sum + 1000];
	        }
	    
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int []nums={1, 1, 1, 1, 1};
		int S=3;
		System.out.println(findTargetSumWays(nums, S));
	}

}
