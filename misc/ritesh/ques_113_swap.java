package pepques;

import java.util.Scanner;

public class ques_113_swap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			StringBuilder st=new StringBuilder();
			
			long no=s.nextInt();
			int p1=s.nextInt();
			int p2=s.nextInt();
			long n=s.nextInt();
			long set1=0;
			long set2=0;
		for(int i=p1;i<p1+n;i++)
		{
			set1=set1|1<<i;
		}
		for(int i=p2;i<p2+n;i++)
		{
			set2=set2|1<<i;
		}
			no=no^set1^set2;
			
					System.out.println(no);
			
			t--;
		}
	}

}
