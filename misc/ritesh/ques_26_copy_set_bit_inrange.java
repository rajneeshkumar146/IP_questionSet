package pepques;

import java.util.Scanner;

public class ques_26_copy_set_bit_inrange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			
			int x=s.nextInt();
			int l=s.nextInt();
			int r=s.nextInt();
			int y=s.nextInt();
			
			for(int i=l-1;i<r;i++)
			{
				if((y&1<<i)!=0)
				{
					x=x|(1<<i);
				}
				
				
			}
			System.out.println(x);
			t--;
		}
	}

}
