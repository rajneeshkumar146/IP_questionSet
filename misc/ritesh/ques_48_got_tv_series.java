package pepques;

import java.util.Scanner;

public class ques_48_got_tv_series {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 * oserve pattern in ques the pattern tells that he can watch th series n*no of set bit 
 * in that number
 */
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			long n=s.nextInt();
			String st=Long.toBinaryString(n);
			int one=0;
			for(int i=0;i<st.length();i++)
			{
				if(st.charAt(i)=='1')
					one++;
			}
			System.out.println(one*n);
			t--;
		}
	}

}
