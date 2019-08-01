package InternQuestDP;

import java.util.Scanner;

public class Cutted_Segments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			int x=scn.nextInt();
			int y=scn.nextInt();
			int z=scn.nextInt();
			int dp[]=new int[n+1];
			if(x<=n){
			dp[x]=1;}
			if(y<=n){
			dp[y]=1;
			}
			if(z<=n){
			dp[z]=1;
			}
			for(int i=0;i<=n;i++){
				if(i>=x && dp[i-x]>0 )
					dp[i]=Math.max(dp[i],1+dp[i-x]);
					if(i>=y && dp[i-y]>0 )
					dp[i]=Math.max(dp[i],1+dp[i-y]);
					if(i>=z && dp[i-z]>0)
					dp[i]=Math.max(dp[i],1+dp[i-z]);
			}
//			for(int i=0;i<=n;i++){
//				System.out.print(dp[i]+" ");
//			}
			System.out.println(dp[n]);
			

		}

	}

}
