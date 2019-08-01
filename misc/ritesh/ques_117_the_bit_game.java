package pepques;

import java.util.Scanner;

public class ques_117_the_bit_game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		StringBuilder str=new StringBuilder();
		while(t>0)
		{
			String s1=s.next();
			long n=Long.parseLong(s1);
			//System.out.println(n);
			int no=2;
			int left=0;
			int right=0;
		int cnt=0;
				String st=Long.toBinaryString(n);
				System.out.println(st);
				left=0;
				right=st.length()-1;
				while(left<right)
				{
					while(left<=right&&st.charAt(right)!='0')
					{
						right--;
					}
					
					if(left==right)
						break;
					
					
					while(left<=right&&st.charAt(left)!='1')
					{
						left++;
					}
					
					if(left==right)
						break;
					
					
				//	if(right>left)
					cnt=1-cnt;
					right--;
					left++;
				}
//			if(cnt%2==0)
//			{
//				System.out.println("1");
//			}
//			else
//				System.out.println("2");
//			
				System.out.println(2-cnt);
			t--;
		}
		//110001010111111000110111101111110000100
	}

}
