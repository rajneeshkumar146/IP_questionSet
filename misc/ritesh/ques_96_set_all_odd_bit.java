package pepques;

import java.util.Scanner;

public class ques_96_set_all_odd_bit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			int no=n;
			int cnt=0;
			while(  n>0)
			{
			   if(cnt%2==0)
			   {
				   no=no|1<<cnt;
			   }
			  
			   n=n&~(1<<cnt);
			   cnt++;
			}
		
			System.out.println(no);
			t--;
		}
	}

}
