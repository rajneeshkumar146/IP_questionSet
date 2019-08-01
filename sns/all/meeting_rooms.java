package SnS;

import java.util.Arrays;

public class meeting_rooms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] intervals= {{1,30,},{35,45},{1,60}};
		System.out.println(canAttendMeetings(intervals));
	}
	 public static boolean canAttendMeetings(int[][] intervals) {
		    
	        inter[] arr=new inter[intervals.length];
	        for(int i=0;i<intervals.length;i++){
	            arr[i]=new inter(intervals[i][0],intervals[i][1]);
	        }
	        
	        Arrays.sort(arr);
	        for(int i=1;i<intervals.length;i++){
	            if(arr[i].st<arr[i-1].et){
	                return false;
	            }
	        }
	        return true;
	    }
	    
	    public static class inter implements Comparable<inter> {
	        int st;
	        int et;
	        
	        inter(int st,int et){
	            this.st=st;
	            this.et=et;
	        }
	        public int compareTo(inter o){
	            return this.st-o.st;
	        }
	    }
	   

}
