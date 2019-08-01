package pepques;

import java.util.ArrayList;
import java.util.Scanner;

public class ques_168_monotone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		System.out.println(monotone(n));
	}
	public static int monotone(int n)
	{
		if(n==0)
			return n;
		ArrayList<Integer> no=new ArrayList<>();
		int tem=n;
		while(tem!=0)
		{
			int a=tem%10;
			no.add(a);
			tem/=10;
		}
		int sz=no.size()-1;
		int cry=0;
		for(int i=sz-1;i>=0;i--)
		{
			
			if(no.get(i)<no.get(i+1))
			{
				
				int num=no.get(i+1);
				cry=1;
				
				no.set(i+1, num-1);
				no.set(i, 9);
			}
			else
			{
				int num=no.get(i);
				if(cry==1)
				{
					no.set(i, 9);
				}
				
				
			}
			
		}
		int pow=1;
		int ans=0;
		for(int i=0;i<no.size();i++)
		{
			ans+=no.get(i)*pow;
			pow*=10;
		}
		return ans;
	}

}
