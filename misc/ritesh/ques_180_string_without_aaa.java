package pepques;

import java.util.Scanner;

public class ques_180_string_without_aaa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int a=s.nextInt();
		int b=s.nextInt();
		System.out.println(withoutaaa(a,b));
	}
	public static String withoutaaa(int a,int b)
	{
		StringBuilder str=new StringBuilder();
		while(a>0&&b>0){
		if(a>b)
		{
			while(a>b&&a>0&&b>0)
			{
				if(str.length()>0&&str.charAt(str.length()-1)=='a')
				{
					str.append("b");
					b--;
				}
				str.append("aab");
				a-=2;
				b-=1;
			}
			
				
		}
			else if(b>a)
			{
				if(str.length()>0&&str.charAt(str.length()-1)=='b')
				{
					str.append("a");
					a--;
				}
				while(b>a&&a>0&&b>0)
				{
					str.append("bba");
					a-=1;
					b-=2;
				}
				
			}
			else
			{
				while(a>0&&b>0){
				str.append("ab");
				a-=1;
				b-=1;
				}
			}
		}
		if(a>0)
		{
			while(a>0)
			{
				str.append("a");
				a--;
			}
		}
		else
		{
			while(b>0)
			{
				str.append("b");
				b--;
			}
		}
		
		return str.toString();
	}

}
