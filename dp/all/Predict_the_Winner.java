package InternQuestDP;

import java.util.Scanner;

public class Predict_the_Winner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int nums[] = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = scn.nextInt();
		}

		boolean p1win = PridictWinner(nums);
		System.out.println(p1win);

	}

	private static boolean PridictWinner(int[] nums) {
		int[][] dp = new int[nums.length + 1][nums.length];
		

		for (int gap = 0; gap < nums.length; gap++) {
			for (int i = 0, j = i + gap; j < nums.length; j++, i++) {
				if (gap == 0) {
					dp[i][j] = nums[i];
				} else {
					dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
				}

			}

		}
		for(int i=0;i<nums.length;i++){
			for(int j=0;j<nums.length;j++){
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		return dp[0][nums.length - 1] >= 0 ? true : false;
	}
}
