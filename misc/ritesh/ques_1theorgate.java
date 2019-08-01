package pepques;

import java.util.Scanner;

public class ques_1theorgate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			int []or=new int [n];
			or[0]=s.nextInt();
			int res=or[0];
			for(int i=1;i<n;i++)
			{
			
				or[i]=s.nextInt();
				res=res|or[i];
			}
			System.out.println(res);
			t--;
			
			
		}
	}

}
