package pepques;

import java.util.Scanner;

public class ques_32_even_subset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			int count=0;
			int bsk=1<<0;
			for(int i=0;i<n;i++)
			{
				int n1=s.nextInt();
				if((n1&bsk)==0)
				{
					count++;
				}s
			}
			t--;
		}
	}

}
