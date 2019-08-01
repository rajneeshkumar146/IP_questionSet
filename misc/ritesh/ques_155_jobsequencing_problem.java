package pepques;

import java.util.Arrays;
import java.util.Scanner;

import pepques.ques_153_pizza_lover.order;

public class ques_155_jobsequencing_problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		StringBuilder st=new StringBuilder();
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			job[] j=new job[n];
			int []id=new int[n];
			int []dl=new int[n];
			int []profit=new int[n];
			for(int i=0;i<n;i++)
			{
				id[i]=s.nextInt();
				dl[i]=s.nextInt();
				profit[i]=s.nextInt();
			}
			for(int i=0;i<n;i++)
			{
				j[i]=new job(id[i],dl[i],profit[i]);
			}
			Arrays.sort(j);
			int res=0;
			int max=0;
			max=j[0].profit;
			int cnt=1;
			for(int i=1;i<n;i++)
			{
				if(j[i].dl!=j[i-1].dl)
				{
					res+=max;
					max=j[i].profit;
					cnt++;
					if(i==n-1)
					{
						res+=max;
					}
				}
				else{
					max=Math.max(max, j[i].profit);
				}
			}
			st.append(max+" "+cnt+"\n");
			t--;
		}
		System.out.println(st);
	}

	public static class job implements Comparable<job>{
		int id;
		int dl;
		int profit;
		
	
		 job(int id,int dl,int profit)
		{
			this.dl=dl;
			this.id=id;
			this.profit=profit;
		}
		@Override
		public int compareTo(job o) {
			// TODO Auto-generated method stub
			if(this.dl>o.dl){
				return +1;
			}
			else if(this.dl==o.dl)
			{
						return 0;
			}
			else return -1;
			
		}
	}

}
