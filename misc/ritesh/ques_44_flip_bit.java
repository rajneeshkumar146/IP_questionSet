package pepques;

import java.util.Scanner;

public class ques_44_flip_bit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			int a[]=new int [n];
			int cnt=0,max=0;
			int one=0;
			for(int i=0;i<n;i++)
			{
				a[i]=s.nextInt();
				if(a[i]==1)
				{
					cnt=0;
					one++;
				}
				else
				{
					cnt++;
					max=Math.max(max, cnt);
				}
			}
			
			System.out.println(max+one);
			t--;
		}
	}

}
