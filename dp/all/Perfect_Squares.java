package InternQuestDP;

import java.util.Scanner;

public class Perfect_Squares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		
		int leastNoSquares=count(n);
		System.out.println(leastNoSquares);

	}

	private static int count(int n) {
		if(n<=3){
			return n;
		}
	   int dp[]=new int[n+1];
	   
	   for(int i=1;i<=3;i++){
		   dp[i]=i;
	   }
	   
	   for(int i=4;i<=n;i++){
		   dp[i]=i;
		   int x=1;
		   for(int j=1;j<i;j++){
			   x=j*j;
			   if(x>i){
				   break;
				   
			   }else{
				   dp[i]=Math.min(dp[i],1+dp[i-x] );
			   }
		   }
	   }
	   
		return dp[n];
	}

}
