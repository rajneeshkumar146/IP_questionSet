package pepques;

import java.util.Scanner;

public class ques_127_xor_of_all_element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			StringBuilder st=new StringBuilder();
			int n=s.nextInt();
			int[]a=new int[n];
			int[]b=new int[n];
			int xor=0;
			for(int i=0;i<n;i++)
			{
				a[i]=s.nextInt();
				xor=(xor^a[i]);
				
				
			}
			
			for(int i=0;i<n;i++)
			{
				int res=xor^a[i];
				st.append(res+" ");
			}
			System.out.println(st);
			t--;
		}
	}

}
