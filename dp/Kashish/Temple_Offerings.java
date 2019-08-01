package InternQuestDP;

import java.util.Scanner;

public class Temple_Offerings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			int height[] = new int[n];
			for (int i = 0; i < n; i++) {
				height[i] = scn.nextInt();
			}

			int offering = totaloffering(height);
			System.out.println(offering);
		}

	}

	private static int totaloffering(int[] height) {
		// TODO Auto-generated method stub
		int dp[] = new int[height.length];
		int dp1[] = new int[height.length];
		int ans = 0;

		for (int i = 0; i < height.length; i++) {
			dp[i] = 1;
			dp1[i]=1;
		}
		for (int i = 1; i < dp.length; i++) {
			if ( i>0 && height[i - 1] < height[i]) {
				dp[i]=dp[i-1]+1;
			} 
		
		}
		for (int i = dp.length-2; i >=0; i--) {
			if (height[i + 1] < height[i]) {
				dp1[i]=dp1[i+1]+1;
			} 
		
		}
		for(int i=0;i<dp.length;i++){
			ans+=Math.max(dp[i], dp1[i]);
		}
//		for(int i: dp){
//			System.out.print( i+" ");
//		}
//		System.out.println();
		return ans;
		
	}

}
