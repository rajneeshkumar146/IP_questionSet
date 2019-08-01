package InternQuestDP;

import java.util.Scanner;

public class Reach_the_Nth_point {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		while(t-->0){
			int n=scn.nextInt();
			long dp[]= new long[n+1];
			dp[0]=1;
			dp[1]=1;
			for(int i=2;i<=n;i++){
				dp[i]=dp[i-1]+dp[i-2];
			}
			
			
			
			System.out.println(dp[n]);
			
		}

	}

}
