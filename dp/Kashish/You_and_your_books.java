package InternQuestDP;

import java.util.Scanner;

public class You_and_your_books {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			int k = scn.nextInt();
			int hi[] = new int[n];
			for (int i = 0; i < n; i++) {
				hi[i] = scn.nextInt();
			}
			int []dp=new int[n];
			if(hi[0]<=k){
			dp[0]=hi[0];}
			else{
				dp[0]=0;
			}
			for(int i=1;i<n;i++){
				if(hi[i]<=k && hi[i-1]<=k){
					dp[i]=hi[i]+dp[i-1];
				}
				else if(hi[i]<=k && hi[i-1]>k){
					dp[i]=hi[i];
				}
				else{
					dp[i]=0;
				}
			}
			
			int max=Integer.MIN_VALUE;
			for(int i=0;i<n;i++){
				max=Math.max(max, dp[i]);
			}
			
//			for(int i=0;i<n;i++){
//				System.out.print(dp[i]+" ");
//			}
			System.out.println(max);
			

		}

	}

}
