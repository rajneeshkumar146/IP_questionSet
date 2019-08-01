package pepques;

import java.util.Arrays;
import java.util.Scanner;

public class ques_171_page_fault {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
			int cap=s.nextInt();
			int b[]=new int[cap];
			Arrays.fill(b,-1);
			int j=0;
			int res=4;
			for(int  i=0;i<n;i++)
			{
				if(b[j]==-1)
				{
					b[j]=a[i];
					j++;
				}
				else if(b[j]!=a[i] && b[j]!=-1)
				{
					b[j]=a[i];
					res++;
					j++;
				}
				
				else {
				b[j]=a[i];
				}
				j=j%cap;
				
			}
			System.out.println(res);
			t--;
		}
	}

}
