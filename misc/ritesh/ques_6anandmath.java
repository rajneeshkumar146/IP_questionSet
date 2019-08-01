package pepques;

import java.util.ArrayList;
import java.util.Scanner;

public class ques_6anandmath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int  t=s.nextInt();
		while(t>0)
		{
			long n=s.nextLong();
			int noz=0;
			
			while(n!=0)
			{
			
				if(n%2==0)
					noz++;
				n=n/2;
			}
			
			
			   
			System.out.println((long)Math.pow(2, noz));
			t--;
			
			
		}

	}

}
