package pepques;

import java.util.Scanner;

public class ques_3toggle_bit_given_range {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();//no of test case
		while(t>0)
		{
			int n=s.nextInt();
			int l=s.nextInt();
			int r=s.nextInt();
		    int  rs=(1<<(r))-1;//give the allsetset bit except rth position
		    int ls=(1<<(l-1))-1;//give the allsetset bit except rth posithin
		    int asltor=rs^ls ;//give the all set bit from lth right most to rth right  most
		
			System.out.println(n^asltor);
			t--;
			
			
		}

	}

}
