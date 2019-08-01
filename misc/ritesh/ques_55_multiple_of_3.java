package pepques;

import java.util.Scanner;

public class ques_55_multiple_of_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			StringBuilder st=new StringBuilder(s.next());
			int od=0;
			int even=0;
			st.reverse();
			for(int i=0;i<st.length();i++)
			{
				if(st.charAt(i)=='1')
				{
					if(1%2==0)
					od++;
					else
						even++;
				}
				
			}
			
			if((od-even)%3==0)
			{
				System.out.println("1");
			}
			else
				System.out.println("0");
			t--;
		}
	}

}
