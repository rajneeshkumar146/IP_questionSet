package pepques;

import java.util.Scanner;

public class ques_114_swap_every_two_bit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			long n=s.nextInt();
			String str=Long.toBinaryString(n);
			StringBuilder st=new StringBuilder();
			if(str.length()%2!=0)
			{
				st.append(0);
			}
			st.append(str);
			st.reverse();
			int cnt=0;
			for(int i=0;i<st.length();i++)
			{
				
				if(i%2!=0)
				{
					char tem=st.charAt(i);
					st.setCharAt(i, st.charAt(i-1));
					st.setCharAt(i-1, tem);
				}
				
			}
			st.reverse();
			str=st.toString();
			System.out.println(Integer.parseInt(str,2));
			t--;
		}
		
	}

}
