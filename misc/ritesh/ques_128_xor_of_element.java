package pepques;

import java.util.Scanner;

public class ques_128_xor_of_element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			StringBuilder st=new StringBuilder();
			int a=s.nextInt();
			int b=s.nextInt();
			String s1=Integer.toBinaryString(a);
			String s2=Integer.toBinaryString(b);
			int l1=s1.length();
			int l2=s2.length();
			if(l1<l2)
			{
				st.append(s1);
				for(int i=0;i<l2-l1;i++)
				{
					st.append('0');
				}
				s1=st.toString();
			}
			else
			{
				st.append(s2);
				for(int i=0;i<l1-l2;i++)
				{
					st.append('0');
				}
				s2=st.toString();
			}
			int xor=Integer.parseInt(s1,2)^Integer.parseInt(s2,2);
			System.out.println(xor);
			t--;
		}
	}

}
