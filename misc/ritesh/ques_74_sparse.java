package pepques;

import java.util.Scanner;

public class ques_74_sparse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int no=s.nextInt();
			int i=0;
			int cnt=0;
			while(no!=0)
			{
				if((no&1<<i)!=0)
				{
					cnt++;
					no=no&~(1<<i);
				}
				
				else{
					cnt=0;
				}
				if(cnt>1)
				{
					
					break;
				}
				i++;
			}
			if(cnt==1)
			System.out.println("1");
			else
				System.out.println("0");
			
			
			t--;
		}
	}

}
