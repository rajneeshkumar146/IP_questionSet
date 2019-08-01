package pepques;

import java.util.Scanner;

public class ques_143_coin_pile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			int k=s.nextInt();
			int a[]=new int [n];
			int sum=0,ans=0;
			int min=Integer.MAX_VALUE;
			for(int i=0;i<n;i++)
			{
				a[i]=s.nextInt();
				min=Math.min(min, a[i]);
			}
			sum=min+k;
			for(int i=0;i<n;i++)
			{
				if(a[i]>sum)
				{
					ans+=a[i]-sum;
				}
			}
			System.out.println(ans);
			t--;
		}
	}

}
