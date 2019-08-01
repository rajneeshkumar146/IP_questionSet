package InternQuestDP;

import java.util.Scanner;

public class stone_game {
	 public static  boolean stoneGame(int[] piles) {
		 int[][] dp = new int[piles.length + 1][piles.length];
			

			for (int gap = 0; gap < piles.length; gap++) {
				for (int i = 0, j = i + gap; j < piles.length; j++, i++) {
					if (gap == 0) {
						dp[i][j] = piles[i];
					} else {
						dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
					}

				}

			}
		
			return dp[0][piles.length - 1] >= 0 ? true : false;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int piles[]={5,3,4,5};
		System.out.println(stoneGame(piles));
		

	}

}
