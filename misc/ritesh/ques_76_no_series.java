package pepques;

import java.util.Scanner;

public class ques_76_no_series {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			int cnt=0;
			int idx=0;
			while(cnt==0)
			{
				if((n&1<<idx)!=0)
				{
					cnt++;
					break;
				}
				idx++;
			}
			
			System.out.println(idx);
			t--;
		}
	}

}
