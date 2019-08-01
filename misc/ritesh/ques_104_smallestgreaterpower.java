package pepques;

import java.util.Scanner;

public class ques_104_smallestgreaterpower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			if((n&(n-1))==0)
			{
				System.out.println(n);
			}
			else{
			int left=-1;
			while(n!=0)
			{
				n=n/2;
				left++;
			}
			left++;
			System.out.println((int)Math.pow(2, left));
			}
			t--;
		}
	}

}
