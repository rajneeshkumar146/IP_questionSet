package pepques;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;



public class ques_166_minimum_platform {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			
			sche [] ti=new sche[2*n] ;
			int[]a=new int[n];
			int[]b=new int[n];
			int i=0;
			for(i=0;i<n;i++)
			{
				ti[i]=new sche(s.nextInt(),'a');
				
			}
			for(int j=0;j<n;j++,i++)
			{
				
				ti[i]=new sche(s.nextInt(),'d');
				
			}
			
//			for(int i=0;i<n;i++)
//			{
//				
//				
//			}
//			for(int i=0;i<n;i++)
//			{
//				ti[i]=new sche(b[i],'d');
//				
//			}
			Arrays.sort(ti);
			System.out.println(maxactivity(ti));
			t--;
		}
	}
	public static  int maxactivity(sche[] t){

		int max=-1;
		int cnt=0;
		
		for(int i=0;i<t.length;i++)
		{
			int a1=t[i].time;
			char ch=t[i].type;
			if(t[i].type=='a')
			{
				cnt++;
			}
			else{
				cnt--;
			}
			max=Math.max(max, cnt);
		}
		return max;
		
	}
	public static class sche implements Comparable<sche>{
		int time;
		char type;
		sche(int start,char type)
		{
			this.time=start;
			this.type=type;
		}

		@Override
		public int compareTo(sche o) {
			// TODO Auto-generated method stub
			 if(this.time>o.time)
				  return +1;
			  else if(this.time==o.time)
				  return 0;
			  else
				  return -1;
			
		}
	}

}
