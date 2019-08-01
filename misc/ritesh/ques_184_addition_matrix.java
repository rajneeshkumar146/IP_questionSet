package pepques;

import java.util.Scanner;

public class ques_184_addition_matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			StringBuilder str=new StringBuilder();
			int n=s.nextInt();
			int a[][]=new int [n][n];
			int [][] b=new int [n][n];
			int [][] c=new int [n][n];
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					a[i][j]=s.nextInt();
				}
			}
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					b[i][j]=s.nextInt();
				}
			}
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					c[i][j]=a[i][j]+b[i][j];
				}
			}
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					str.append(c[i][j]+" ");
				}
			}
			System.out.println(str);
			t--;
		}
	}

}
