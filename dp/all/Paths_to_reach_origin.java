package InternQuestDP;

import java.util.Scanner;

public class Paths_to_reach_origin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		while(t-->0){
			int n=scn.nextInt();
			int m=scn.nextInt();
			int tpaths=countPaths(n,m);
			System.out.println(tpaths);
		}

	}

	private static int countPaths(int n, int m) {
		
		
		int dp[][]=new int[n+1][m+1];
		for(int i=0;i<=n;i++){
			dp[i][0]=1;
		}
		for(int j=0;j<=m;j++){
			dp[0][j]=1;
		}
		
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				dp[i][j]=dp[i][j-1]+dp[i-1][j];
			}
		}
		

		return dp[n][m];
	}

}
