package pepques;

import java.util.Scanner;

public class ques_94_rightmost_different_bit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int  n=s.nextInt();
			int m=s.nextInt();
			StringBuilder sb1=new StringBuilder();
			StringBuilder sb2=new StringBuilder();
			String s1=Integer.toBinaryString(n);
			sb1.append(s1);
			sb1.reverse();
			String s2=Integer.toBinaryString(m);
			
			sb2.append(s2);
			sb2.reverse();
			if(sb1.equals(sb2))
			{
				System.out.println(-1);
			}
			else{
			int cnt =0;
			while(cnt<sb1.length()&&cnt<sb2.length())
			{
				if(sb1.charAt(cnt)!=sb2.charAt(cnt))
				{
					break;
				}
				
				cnt++;
			}
			if(!(cnt<Math.min(sb1.length(), sb2.length()))){
			while(cnt<sb1.length())
			{
				if(sb1.charAt(cnt)=='1')
				{
					break;
				}
				cnt++;
			}
			
			while(cnt<sb2.length())
			{
				if(sb1.charAt(cnt)=='1')
				{
					break;
				}
				cnt++;
			}
			}
			System.out.println(cnt+1);
			}
			
			
			
			
			t--;
		}
	}

}
