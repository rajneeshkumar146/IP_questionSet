package pepques;

import java.util.Scanner;

public class ques_53_invert_thebit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			long n=s.nextLong();
		    String ss=Long.toBinaryString(n);
			
		
			StringBuilder s1=new StringBuilder();
			for(int i=ss.length()-1;i<31;i++)
			{
				s1.append('0');
			}
			s1.append(ss);
			for(int i=0;i<s1.length();i++)
			{
				if(s1.charAt(i)=='1')
				{
					s1.setCharAt(i, '0');
				}
				else 
					s1.setCharAt(i, '1');
				
			}
			
			String str;
			str=s1.toString();
			s1.delete(0, s1.length());
			System.out.println(Long.parseLong(str,2));
			t--;
		}
	}

}
