package pepques;

import java.util.Scanner;

public class ques_31_sum_nd_xor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//when at the possition of zero if we do xor and or in both casese value would be same s
		//so count the no of zeros and the find total possible set that is 2^n
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			String st=Integer.toBinaryString(n);
			int cnt=0;
			for(int i=0;i<st.length();i++)
			{
				if(st.charAt(i)=='0')
				{
					cnt++;
				}
				
			}
			System.out.println((int)Math.pow(2, cnt));
			t--;
		}
	}

}
