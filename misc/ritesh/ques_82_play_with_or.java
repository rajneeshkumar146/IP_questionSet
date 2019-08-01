package pepques;

import java.util.Scanner;

public class ques_82_play_with_or {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			int a[]=new int[n];
			int a1[]=new int[n];
			for(int i=0;i<n;i++)
			{
				a[i]=s.nextInt();
			}
			
			for(int i=0;i<n-1;i++)
			{
				a1[i]=a[i]|a[i+1];
			}
			a1[n-1]=a[n-1];
			for(int i=0;i<n;i++)
			{
				System.out.print(a1[i]+" ");
			}
			System.out.println();
			t--;
		}
	}

}
