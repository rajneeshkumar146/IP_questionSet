package pepques;

import java.util.Scanner;

public class ques_116_the_and_gate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			int res=1;
			for(int i=0;i<n;i++)
			{
				int bit=s.nextInt();
				res=res&bit;
				
			}
			System.out.println(res);
			t--;
		}
	}

}
