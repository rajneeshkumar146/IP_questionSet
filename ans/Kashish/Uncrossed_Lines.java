package InternQuestAS1;

import java.util.Scanner;

public class Uncrossed_Lines {
	 public static  int maxUncrossedLines(int[] a, int[] b) {
		 int m = a.length, n = b.length,
				 dp[][] = new int[m + 1][n + 1];
	        for (int i = 1; i <= m; ++i){
	            for (int j = 1; j <= n; ++j){
	                if (a[i - 1] == b[j - 1])
	                    {dp[i][j] = 1 + dp[i - 1][j - 1];}
	                else
	                { dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);}
	            }
	        }
	        return dp[m][n];
		 
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int []a={1,3,7,1,7,5};
		int[]b= {1,9,2,5,1};
		System.out.println(maxUncrossedLines(a, b));
		
		

	}

}
