package pepques;

import java.util.Scanner;

public class ques_22_check_Kth_Bit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			
		int no=s.nextInt();
		int k=s.nextInt();
		iskthset(no,k);
			t--;
		}
	}
public static void iskthset(int no,int k)
{
	if((no&1<<(k))!=0)
	{
		System.out.println("Yes");
	}
	else 
		System.out.println("No");
	return;
}
}
