package pepques;

import java.util.Scanner;

public class ques_11_nextbinaryrepresentation {

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
			for(int i=los-1;i>=0;i--)
			{
				if(no.charAt(i)=='1')
				{
					nextno.setCharAt(i, '0');
				}
				else
				{
					flag=true;
					nextno.setCharAt(i, '1');
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
			if(flag==false)
			{
				System.out.println("1"+nextno);
			}
			else
				System.out.println(nextno.substring(istleftsetbit, no.length()));
			t--;
			
		}
	}

}
