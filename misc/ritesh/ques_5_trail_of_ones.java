package pepques;

import java.util.Scanner;

public class ques_5_trail_of_ones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();//no of test case
		while(t>0)
		{
			int n=s.nextInt();
			int zero[]=new int[n+1];
			int one[]=new int [n+1];
			t--;
			zero[1]=1;
			one[1]=1;
			for(int i=2;i<n+1;i++)
			{
				zero[i]=zero[i-1]+one[i-1];
				one[i]=zero[i-1];
			}
			int totalss=(int)Math.pow(2, n);
			System.out.println(totalss-one[n]-zero[n]);
			
		}
		
	}

}
