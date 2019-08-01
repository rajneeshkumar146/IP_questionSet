package pepques;

import java.util.ArrayList;
import java.util.Scanner;

public class ques_10_binaryrepresentation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		int count=13;
		
		while(t>0)
		{
			
			int n=s.nextInt();
		
			   for(int i=count;i>=0;i--)
			   {
				   if((n&1<<i)==0)
				   {
					   System.out.println("0");
				   }
				   else
					   System.out.println("1");
                   
			   }
			
			t--;
			
		}
	}

}
