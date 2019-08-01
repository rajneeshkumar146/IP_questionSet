package pepques;

import java.util.Scanner;

public class ques_79_odd_even {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			if((n&1<<0)==0)
			{
				System.out.println("even");
			}
			else
			{
				System.out.println("odd");
			}
			t--;
		}
	}

}
