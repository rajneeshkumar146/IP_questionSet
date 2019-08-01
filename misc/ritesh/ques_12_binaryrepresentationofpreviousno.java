package pepques;

import java.util.Scanner;

public class ques_12_binaryrepresentationofpreviousno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		
		
		while(t>0)
		{
			String no=s.next();
			StringBuilder nextno=new StringBuilder();
			nextno.append(no);
			int los=no.length();
			boolean flag=false;
			int i;
			for( i=los-1;i>=0;i--)
			{
				if(no.charAt(i)=='0')
				{
					nextno.setCharAt(i, '1');
				}
				else
				{
					flag=true;
					nextno.setCharAt(i, '0');
					break;
				}
			}
			int istleftsetbit=0;
			for(int j=0;j<los;j++)
			{
				if(nextno.charAt(j)=='1')
				{
					istleftsetbit=j;
					break;
				}
			}
			if(i==0)
			{
				nextno.deleteCharAt(0);
				System.out.println(nextno);
			}
			else
				System.out.println(nextno.substring(istleftsetbit, no.length()));
			t--;
			
		}

	}

}
