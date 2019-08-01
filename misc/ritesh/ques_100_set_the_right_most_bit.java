package pepques;

import java.util.Scanner;

public class ques_100_set_the_right_most_bit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			int k=0;
			int no=n;
			while((n&1<<k)!=0 && no!=0)
			{
			    no=no&~(1<<k);
				k++;
			}
			if (no==0)
			{
			    k--;
			}
			n=n|1<<k;
			System.out.println(n);
			t--;
		}
	}

}
