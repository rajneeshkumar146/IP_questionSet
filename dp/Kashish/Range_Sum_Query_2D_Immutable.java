package InternQuestDP;

import java.util.Scanner;

public class Range_Sum_Query_2D_Immutable {
	  private static int[][] dp;

	  public static void  NumMatrix(int[][] matrix) {
	      dp = new int[matrix.length + 1][matrix[0].length + 1];
	      for (int i = 0; i < matrix.length; i++) {
	          for (int j = 0; j < matrix[0].length; j++) {
	              dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1] + matrix[i][j] - dp[i][j];
	          }
	      }
	  }

	  public static int sumRegion(int r1, int c1, int r2, int c2) {
	      return dp[r2 + 1][c2 + 1] - dp[r1][c2 + 1] - dp[r2 + 1][c1] + dp[r1][c1];
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		
		int[][] matrix = {
		                {3, 0, 1, 4, 2},
		                {5, 6, 3, 2, 1},
		                {1, 2, 0, 1, 5},
		                {4, 1, 0, 1, 7},
		                {1, 0, 3, 0, 5}
		};
		  
		NumMatrix(matrix);
		for(int i=0;i<dp.length;i++){
			for(int j=0;j<dp[0].length;j++){
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		
		             System.out.println(sumRegion(2, 1, 4, 3));		  

	}

}
