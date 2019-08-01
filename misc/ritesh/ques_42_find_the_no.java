package pepques;

import java.util.Arrays;
import java.util.Scanner;

public class ques_42_find_the_no {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 * xor of two same no is zero so when we send time we find xor then when the no
 * become zero than means our both single no is repeatd so previous would be ans
 */
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			int a[]=new int [2*n+2];
			int xor=0;
			int no1=0;
			int no2=0;
			for(int i=0;i<a.length;i++)
			{
				a[i]=s.nextInt();
				xor^=a[i];
			}
			Arrays.sort(a);
			int tem=0;
			int pre=0;
			for(int i=0;i<a.length;i++)
			{
				tem=tem^a[i];
				if(i%2==1 && tem!=0)
				{
					no1=pre;
					break;
				}
				pre=a[i];
			}
			no2=no1^xor;
			
			System.out.println(no1+" "+no2);
			t--;
		}
	}

}
