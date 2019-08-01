package pepques;

import java.util.Scanner;

public class ques_81_parity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int no=s.nextInt();
			int cnt=0;
			int i=0;
			while(no!=0)
			{
				if((no&1<<i)!=0)
				{
					cnt++;
					no=no&~(1<<i);
				}
				
				
				
				i++;
			}	
			if(cnt%2==0)
			{
				System.out.println("even");
				
			}
			else System.out.println("odd");
			t--;
		}
	}

}
