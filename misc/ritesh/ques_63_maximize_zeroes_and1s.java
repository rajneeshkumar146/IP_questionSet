package pepques;

import java.util.Scanner;

public class ques_63_maximize_zeroes_and1s {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			String st=Integer.toBinaryString(n);
			int cnt=0,max=0;
			int one=0;
			boolean f=false;
			for(int i=0;i<st.length();i++)
			{
			
				if(st.charAt(i)=='1')
				{
				    	max=Math.max(max, cnt);
					cnt=0;
					one++;
					f=true;
				}
				else if(f==true)
				{
					cnt++;
				
				}
			}
			if(one<2)
				System.out.println(-1);
			else
			System.out.println(max);
			t--;
		}
	}

}
