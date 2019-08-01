package pepques;

import java.util.Scanner;

public class ques_19_noisDivisible_by_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n;
			String no=s.next();
			if(no.length()<=3)
			{
			     n=Integer.parseInt(no);
			}
			else
			 n=Integer.parseInt(no.substring(no.length()-3, no.length()));
			//cauz last three bit should be off if
			//it is divisible by 8
			if(n%8==0)
				System.out.println(1);
			else
				System.out.println(-1);
			t--;
		}
	}

}
