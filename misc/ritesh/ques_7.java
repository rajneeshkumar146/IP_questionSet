package pepques;

import java.util.Scanner;

public class ques_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s =new Scanner(System.in);
		int  t=s.nextInt();
		while(t>0)
		{
			int left=s.nextInt();
			int right=s.nextInt();
			int res=left;
			for(int i=left+1;i<=right;i++)
			{
				res=res&i;
			}
			System.out.println(res);
			t--;
			
			
		}
	}

}
