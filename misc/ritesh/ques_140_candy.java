package pepques;

import java.util.Arrays;
import java.util.Scanner;

import pepques.ques_136_selection_activity.sche;

public class ques_140_candy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			int [] c=new int [n];
			
		
			for(int i=0;i<c.length;i++)
			{
				c[i]=s.nextInt();
			}
			min(c);
			t--;
		}
	}
	public static void min( int [] c)
	{
		int min=0;
		int ltr[]=new int[c.length]; 
		int rtl[]=new int[c.length]; 
		ltr[0]=1;
		ltr[c.length-1]=1;
		rtl[c.length-1]=1;
		rtl[0]=1;
		for(int i=1;i<c.length;i++)
		{
			if(c[i]>c[i-1])
			{
				ltr[i]=ltr[i-1]+1;
			}
			else
				ltr[i]=1;
		}
		for(int i=c.length-2;i>=0;i--)
		{
			if(c[i]>c[i+1])
			{
				rtl[i]=rtl[i+1]+1;
			}
			else
				rtl[i]=1;
		}
		for(int i=0;i<c.length;i++)
		{
			min=min+Math.max(ltr[i], rtl[i]);
		}
		System.out.println(min);
	}
	
	

}
