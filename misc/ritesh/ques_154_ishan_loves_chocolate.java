package pepques;

import java.util.Arrays;
import java.util.Scanner;

import pepques.ques_153_pizza_lover.order;

public class ques_154_ishan_loves_chocolate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		StringBuilder st=new StringBuilder();
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			int choc[]=new int  [n];
			int min=Integer.MAX_VALUE;
			for(int i=0;i<n;i++)
			{
				 choc[i]=s.nextInt();
				min=Math.min(min, choc[i]);
				
			}
			
			Arrays.sort(choc);
			st.append(min+"\n");
		
			t--;
		}
		System.out.println(st);
	}

}
