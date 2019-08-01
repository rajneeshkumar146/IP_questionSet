package pepques;

import java.util.Scanner;

public class ques_69_midori_nd_cho {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			int l=s.nextInt();
			int num=1<<(l-1);
			 num^=(num-1);
			System.out.println(num-n+1);
			t--;
		}
	}

}
