package pepques;

import java.util.Arrays;
import java.util.Scanner;

import may21.snqs.sche;

public class ques_136_selection_activity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
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
				
				time[i]=new sche(start[i],end[i]);
			}
			Arrays.sort(time);
			
			System.out.println(maxactivity(time));
			t--;
		}
	}
	public static  int maxactivity(sche[] time){
		int count=1;
		int lstval=time[0].end;
		for(int i=1;i<time.length;i++)
		{
			
			if(time[i].start>lstval)
			{
				lstval=time[i].end;
				count++;
			}
		}
		return count;
	}
	public static class sche implements Comparable<sche>{
		int start;
		int end;
		sche(int start,int end)
		{
			this.start=start;
			this.end=end;
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
