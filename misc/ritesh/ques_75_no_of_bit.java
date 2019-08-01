package pepques;

import java.util.Scanner;

public class ques_75_no_of_bit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
//			String st=s.nextLine();
//			int cnt=0;
//			for(int i=0;i<st.length();i++) if it is string
//			{
//				if(st.charAt(i)=='1')
//					cnt++;
//			}
//			System.out.println(cnt);
			int n=s.nextInt();
			int cnt=0;
	        int i=0;
					while(n!=0)
				{
					if((n&1<<i)!=0)
					{
						cnt++;
						n=n&~(1<<i);
					}
	                    i++;
	                }
	       System.out.println(cnt);
			t--;
			
		}
	}

}
