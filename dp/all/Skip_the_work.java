package InternQuestDP;

import java.util.Scanner;

public class Skip_the_work {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		while(t-->0){
			int n=scn.nextInt();
			int arr[]=new int[n];
			for(int i=0;i<n;i++){
				arr[i]=scn.nextInt();
			}
			int mintime=CalculateMin(arr);
			System.out.println(mintime);
		}
		

	}

	private static int CalculateMin(int[] arr) {
		// TODO Auto-generated method stub
		int dp[][]=new int[2][arr.length];
		dp[0][0]=arr[0];
		for(int j=1;j<arr.length;j++){
			dp[0][j]=Math.min(dp[0][j-1],dp[1][j-1])+arr[j];
			dp[1][j]=dp[0][j-1];
		}
		
		return Math.min(dp[0][arr.length-1], dp[1][arr.length-1]);
	}

}
