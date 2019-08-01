package pepques;

import java.util.Scanner;

public class ques_58_longest_consecutive_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int no=s.nextInt();
			int cnt=0;
			int max=0;
			int i=0;
			while(no!=0)
			{
				if((no&1<<i)!=0)
				{
					cnt++;
					no=no&~(1<<i);
				}
				else
					cnt=0;
				max=Math.max(max, cnt);
				i++;
			}
			System.out.println(max);
			t--;
		}
	}

}
