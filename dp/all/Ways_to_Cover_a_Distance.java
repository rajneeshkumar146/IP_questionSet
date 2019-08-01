package InternQuestDP;

import java.util.Scanner;

public class Ways_to_Cover_a_Distance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int ways=CountWays(n);
		System.out.println(ways);
 
	}

	private static int CountWays(int n) {
		int dp[]=new int[n+1];
		dp[n]=1;
		for(int i=n-1;i>=0;i--){
			if(i+1<=n){
				dp[i]+=dp[i+1];
			}
			if(i+2<=n){
				dp[i]+=dp[i+2];	
			}
			if(i+3<=n){
				dp[i]+=dp[i+3];
			}
		}
		return dp[0];
	}

}
