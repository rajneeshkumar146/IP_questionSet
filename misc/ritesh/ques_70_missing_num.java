package pepques;

import java.util.Scanner;

public class ques_70_missing_num {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			
			int xor1=0;
			int xor2=0;
			
			for(int i=0;i<n;i++)
			{
				xor1^=s.nextInt();
			}
			for(int i=0;i<n-1;i++)
			{
				xor2^=s.nextInt();
			}
			System.out.println(xor1^xor2);
			t--;
		}
	}

}
