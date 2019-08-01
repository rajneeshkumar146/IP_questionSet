package pepques;

import java.util.Scanner;

public class ques_177_smallest_num {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int sum=s.nextInt();
			int d=s.nextInt();
			int digit[]=new int[d+1];
			if(!(sum>9*d||d==0)){
			sum-=1;
			digit[1]=1;
			
			for(int i=d;i>0;i--)
			{
				if(sum>=9)
				{
					digit[i]+=9;
					sum-=9;
				}
				else
				{
					digit[i]+=sum;
					sum=0;
				}
			}
			for(int i=1;i<=d;i++)
			{
				System.out.print(digit[i]);
			}
			}
			else
			{
				System.out.print(-1);
			}
			System.out.println();
			t--;
		}
	}

}
