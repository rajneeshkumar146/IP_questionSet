package pepques;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

import pepques.ques_136_selection_activity.sche;

public class ques_144_course_Sche {

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
	public static  int maxactivity(sche[] t){
//		for(int i=0;i<n;i++)
//		{
//			
//			time[i]=new sche(c[i][0],c[i][i]);
//		}
//		Arrays.sort(time);
		  int time = 0, count = 0;
		  PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->Integer.compare(b, a));
	        for (int i = 0; i < t.length; i++) {
	         if(time+t[i].start<=t[i].end)
	         {
	        	 time+=t[i].start;
	        	 count++;
	        	 pq.offer(t[i].start);
	         }
	         else if(!pq.isEmpty() && t[i].start < pq.peek()) {
	                time -= pq.peek() -  t[i].start;
	                
	                pq.poll();
	                pq.offer(t[i].start);
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
