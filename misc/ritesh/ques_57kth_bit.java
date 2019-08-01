package pepques;

import java.util.Scanner;

public class ques_57kth_bit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int no=s.nextInt();
			int k=s.nextInt();
			if(((no&1<<(k-1))!=0))
			{
				System.out.println("1");
				
			}
			else System.out.println("0");
			
			t--;
		}
	}

}
