package pepques;

import java.util.Scanner;

public class ques_92_reverse_bit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			long n=s.nextLong();
			String st=Long.toBinaryString(n);
			StringBuilder sb=new StringBuilder();
			
			int nob=st.length();
			 nob=32-nob;
			 for(int i=0;i<nob;i++)
			 {
				 sb.append(0);
			 }
			 sb.append(st);
			sb.reverse();
			
			st=sb.toString();
			long no=Long.parseLong(st,2);
			
			System.out.println(no);
			t--;
		}
	}

}
