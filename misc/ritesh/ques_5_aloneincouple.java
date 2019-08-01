package pepques;

import java.util.Scanner;

public class ques_5_aloneincouple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			int []couple=new int [n];
			int single;
			single=s.nextInt();
			for(int i=1;i<n;i++)
			{
			
				couple[i]=s.nextInt();
				single=single^couple[i];
				
			}
			System.out.println(single);
			t--;
			
			
		}
	}

}
