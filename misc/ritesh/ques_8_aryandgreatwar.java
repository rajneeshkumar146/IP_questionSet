package pepques;

import java.util.Scanner;

public class ques_8_aryandgreatwar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int  t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			int noo=0;
			int count=0;
			
			while(n!=0)
			{
				if((n&1<<count)!=0)
				{
				
					noo++;
					n=n&~(1<<count);
				}
				
				count++;
			}
			
			  
			System.out.println(noo);
			t--;
			
			
		}

	}

}
