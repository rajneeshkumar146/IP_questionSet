package InternQuestDP;

import java.util.Scanner;

public class Perfect_Sum_Problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}
			int tarsum = scn.nextInt();

			int totalsubsets = countsubsets(arr, tarsum);
			System.out.println(totalsubsets);

		}

	}

	private static int countsubsets(int[] arr, int tarsum) {
		int dp[][] = new int[arr.length+1][tarsum + 1];
		for(int j=0;j<dp[0].length;j++){
			dp[0][j]=0;
		}
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
		}
		
		
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (arr[i-1] <= j) {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i-1]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
//		for(int i=0;i<dp.length;i++){
//			for(int j=0;j<dp[0].length;j++){
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}

		return dp[arr.length][tarsum];
	}

}
