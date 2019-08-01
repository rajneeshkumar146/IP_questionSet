package pepques;

import java.util.Scanner;

public class ques_126_count_xor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			String st=Integer.toBinaryString(n);
			int z=0;
			int o=0;
			for(int i=0;i<st.length();i++)
			{
			
				if(st.charAt(i)=='1')
				{
					o++;
				}
				else z++;
			}
			System.out.println(o^z);
			t--;
		}
	}

}
