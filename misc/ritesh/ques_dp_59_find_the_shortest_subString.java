package pepques;

import java.util.Arrays;
import java.util.Scanner;

public class ques_dp_59_find_the_shortest_subString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    System.out.println(permi("DID"));
	    
	}
	public static int permi(String s)
			{
		   int MOD = 1_000_000_007;
	        int N = s.length();

	        
	        int[][] dp = new int[N+1][N+1];
	        Arrays.fill(dp[0], 1);

	        for (int i = 1; i <= N; ++i) {
	            for (int j = 0; j <= i; ++j) {
	                if (s.charAt(i-1) == 'D') {
	                    for (int k = j; k < i; ++k) {
	                        dp[i][j] += dp[i-1][k];
	                        dp[i][j] %= MOD;
	                    }
	                } else {
	                    for (int k = 0; k < j; ++k) {
	                        dp[i][j] += dp[i-1][k];
	                        dp[i][j] %= MOD;
	                    }
	                }
	            }
	        }

	        int ans = 0;
	        for (int x: dp[N]) {
	            ans += x;
	            ans %= MOD;
	        }

	        return ans;
			}

}
