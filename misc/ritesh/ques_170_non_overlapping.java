package pepques;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import pepques.ques_169_n_meeting.sche;

public class ques_170_non_overlapping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			StringBuilder str=new StringBuilder();
			int n=s.nextInt();
			int start[]=new int[n];
			int end[]=new int[n];
			sche [] time=new sche[n] ;
			for(int i=0;i<n;i++)
			{
				start[i]=s.nextInt();
				
			}
			for(int i=0;i<n;i++)
			{
				end[i]=s.nextInt();
				
			}
			for(int i=0;i<n;i++)
			{
				
				time[i]=new sche(start[i],end[i],i);
			}
			Arrays.sort(time);
			int a=meeting(time);
			
			System.out.println(a);
			t--;
		}
	}
	public static  int meeting(sche[] t){

		  if(t.length==0)
		  {
			  return 0;
		  }
		 int a=0;
		  int end=t[0].end;
		
		for(int i=1;i<t.length;i++)
		{
			 
			if(t[i].start<end)
			{
				a++;
			}
			else
			{
				end=t[i].end;
			}
		}
		return a;
	}
	public static class sche implements Comparable<sche>{
		int start;
		int end;
		int i;
		sche(int start,int end,int i)
		{
			this.start=start;
			this.end=end;
			this.i=i+1;
		}

		@Override
		public int compareTo(sche o) {
			// TODO Auto-generated method stub
			 if(this.end>o.end)
				  return +1;
			  else if(this.end==o.end)
				  return 0;
			  else
				  return -1;
			
		}
	}

}
