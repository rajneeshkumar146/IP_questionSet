package pepques;

import java.util.Arrays;
import java.util.Scanner;



public class ques_165_minimum_no_of_arrow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			int start[][]=new int[n][n];
			sche time[]=new sche[n];
			for(int i=0;i<n;i++)
			{
				
				time[i]=new sche(start[i][0],start[i][1]);
			}
			Arrays.sort(time);
			
			System.out.println(maxactivity(time));
			t--;
		}
	}
	public static  int maxactivity(sche[] time){
		int count=1;
		int j=0;;
		
		for(int i=1;i<time.length;i++)
		{
			
			if(time[i].start>time[j].end)
			{
				j=i;
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
			return this.end-o.end;
			
		}
	}

}
