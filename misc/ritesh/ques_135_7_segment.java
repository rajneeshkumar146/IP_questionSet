package pepques;

import java.util.Scanner;

public class ques_135_7_segment {
	public static class seg{
		int [] a={6,2,5,5,4,5,6,3,7,5};
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			int a[]=new int [n];
			int ts=0;
			seg a1=new seg();
			for(int i=0;i<n;i++)
			{
				a[i]=s.nextInt();
				ts+=a1.a[a[i]];
			}
			t--;
		}
	}

}
