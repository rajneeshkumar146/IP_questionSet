package pepques;

import java.util.Scanner;

public class ques_2thexorgate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			int []xor=new int [n];
			xor[0]=s.nextInt();
			int res=xor[0];
			for(int i=1;i<n;i++)
			{
			
				xor[i]=s.nextInt();
				res=res^xor[i];
			}
			System.out.println(res);
			t--;
			
			
		}
	}

}
