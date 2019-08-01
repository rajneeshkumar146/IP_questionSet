package pepques;

import java.util.Scanner;

public class ques_159_lemonade_change {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			int a[]=new int [n];
			for(int i=0;i<n;i++)
			{
				a[i]=s.nextInt();
			}
			System.out.println(change(a));
			t--;
		}
	}
	public static boolean change(int []a)
	{
		if(a[0]!=5)
		{
			return false;
		}
		int dp[] =new int [3];
		for(int i=0;i<a.length;i++)
		{
			int ru=a[i]-5;
			
			if(a[i]==5)
			{
				dp[0]++;
			}
			else
			{
				if(dp[0]==0)
				{
					return false;
				}
				dp[0]--;
				ru-=5;
				int n10=ru/10;
				if(dp[1]>=n10)
				{
					dp[1]-=n10;
				}
				else
				{
					n10=n10-dp[1];
					if(dp[0]>=n10*2)
					{
						dp[0]-=n10*2;
					}
					else 
						return false;
				}
				if(a[i]==10)
					dp[1]++;
				if(a[i]==20)
				{
					dp[2]++;
				}
			}
		}
		return true;
	}

}
