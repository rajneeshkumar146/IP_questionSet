package pepques;

import java.util.Scanner;

public class ques_46_nos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StringBuilder st=new StringBuilder();
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
			
			for(int i=0;i<n-1;i++)
			{
				a[i]^=a[i+1];
			}
			for(int i=0;i<n;i++)
			{
				st.append(a[i]+" ");
			}
			st.append("\n");
			t--;
		}
		System.out.println(st);
	}

}
