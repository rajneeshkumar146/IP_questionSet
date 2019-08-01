package pepques;

import java.util.Scanner;

public class ques_1_1s_compli {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		
		while(t>0)
		{
			int n=s.nextInt();
			int []bit=new int [n];
			
			StringBuilder str=new StringBuilder();
			for(int i=0;i<n;i++)
			{
			
				bit[i]=s.nextInt();
				int res=1<<0^bit[i];
				str.append(res+" ");
			}
			System.out.println(str);
			t--;
			
		}
	}

}
