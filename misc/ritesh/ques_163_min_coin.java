package pepques;

import java.util.Scanner;

public class ques_163_min_coin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			int val=s.nextInt();
			int [] c=new int [n];
			for(int i=0;i<n;i++)
			{
				c[i]=s.nextInt();
			}
			System.out.println(min(c,val));
			
			t--;
		}
	}

	public static int min(int []c,int v)
	{
	
		if(v==0)
			return -1;
		int[] dp=new int [v+1];
		dp[0]=0;
		for(int i=1;i<=v;i++)
		{
			dp[i]=Integer.MAX_VALUE;
			
			for(int j=0;j<c.length;j++)
			{
				int ans=Integer.MAX_VALUE;
				if(i-c[j]>=0)
				{
					ans=dp[i-c[j]];
					if(ans!=Integer.MAX_VALUE)
					dp[i]=Math.min(ans+1, dp[i]);
				}
			}
		}
		if(dp[v]==Integer.MAX_VALUE)
		return -1;
		else return dp[v];
	}
}
