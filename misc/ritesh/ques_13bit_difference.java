package pepques;

import java.util.Scanner;

public class ques_13bit_difference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		
		while(t>0)
		{
			int no1=s.nextInt();
			int no2=s.nextInt();
			int xor=no1^no2;
			int res=0;
			int count=0;
			while(xor!=0)
			{
				if((xor&1<<count)!=0)
				{
					res++;
					xor=xor&~(1<<count);
				}
				count++;
			}
			System.out.println(res);
			t--;
			
		}
	}

}
