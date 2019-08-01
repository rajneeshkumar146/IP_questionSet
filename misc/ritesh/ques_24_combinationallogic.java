package pepques;

import java.util.Scanner;

public class ques_24_combinationallogic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			
			int a=s.nextInt();
			int b=s.nextInt();
			int c=s.nextInt();
			int d=s.nextInt();
			int e=s.nextInt();
			int f=s.nextInt();
			int res=((~(a))&b) | (c&d) |(e&(~(f)));
		System.out.println(res);
			t--;
		}
	}

}
