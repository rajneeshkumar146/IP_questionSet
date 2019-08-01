package pepques;

import java.util.Arrays;
import java.util.Scanner;

public class ques_153_pizza_lover {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		StringBuilder st=new StringBuilder();
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			order or[]=new order [n];
			int []a=new int[n];
			int [] b=new int[n];
			for(int i=0;i<n;i++)
			{
				 a[i]=s.nextInt();
				 b[i]=s.nextInt();
				
			}
			for(int i=0;i<n;i++)
			{
				or[i]=new order(a[i]+b[i],i+1);
			}
			Arrays.sort(or);
			
			
			for(int i=0;i<n;i++)
			{
				st.append(or[i].idx+"\n");
			}
		
			t--;
		}
		System.out.println(st);
	}

	public static class order implements Comparable<order>{
		int n;
		int idx;
		 order(int n,int idx)
		{
			this.n=n;
			this.idx=idx;
		}
		@Override
		public int compareTo(order o) {
			// TODO Auto-generated method stub
			if(this.n>o.n){
				return +1;
			}
			else if(this.n==o.n)
			{
				if(this.idx>o.idx)
					return +1;
				else if(this.idx==o.idx)
					return 0;
					else
						return -1;
			}
			else return -1;
			
		}
	}
}
