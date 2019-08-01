package pepques;

import java.util.Scanner;

public class ques_98_set_bit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			int cnt=0;
			while(  n>0)
			{
			    if(n%2!=0)
			    {
			        cnt++;
			    }
			    n=n/2;
			}
		
			
			System.out.println(cnt);
			t--;
		}
	}

}
