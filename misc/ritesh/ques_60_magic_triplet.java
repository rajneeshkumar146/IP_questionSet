package pepques;

import java.util.Scanner;

public class ques_60_magic_triplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			int a[]=new int [n];
			for(int i=0;i<n;i++)
			{
				a[i]=s.nextInt();
			}
			int j=0;
			int res=0;
			int cnt=1;
			for(int i=1;i<n;i++)
			{
				
			
				if(a[i]>a[i-1])
				{
					cnt++;
				}
				else{
					if(cnt>=3)
					{
						res+=3;
					}
					cnt=1;
				}
				
			}
			if(cnt>=3)
			res+=cnt;
			System.out.println(res);
			t--;
		}
	}

}
