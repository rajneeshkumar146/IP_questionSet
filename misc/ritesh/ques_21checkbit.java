package pepques;

import java.util.Scanner;

public class ques_21checkbit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			
			int no=s.nextInt();
		isallset(no);
			t--;
		}
	}
public static void isallset(long no)
{
	int count=0;
	while (no!=0)
	{
		if((no&1<<count)==0)
		{
			System.out.println("No");
			
			return;
		}
		no=no&~(1<<count);
		count++;
		
	}
	System.out.println("yes");
}
}
