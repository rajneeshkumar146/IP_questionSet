package pepques;

import java.util.Scanner;

public class ques_156_largest_no_possible {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			int sum=s.nextInt();
			
				largest(n,sum);
				System.out.println();
			t--;
		}
	}
	public static  void largest(int n,int s)
	{
		int a[]=new int [n];
		
		if(s>9*n || s==0)
		{
			System.out.print(-1);
			return ;
		}
			
		for(int i=0;i<n;i++)
		{
			if(s-9>=0){
			a[i]=9;
			s-=9;
			}
			else
			{
				a[i]=s;
				s=0;
				break;
			}
		}
		int res=0;
		int pow=1;
		for(int i=0;i<n;i++)
		{
			System.out.print(a[i]);
		}
		return ;
	}

}
