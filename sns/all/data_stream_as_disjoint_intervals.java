package pep_sns;

import java.util.ArrayList;

public class data_stream_as_disjoint_intervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SummaryRanges s = new SummaryRanges();
		s.addNum(1);
		s.addNum(3);
		s.addNum(7);
		s.addNum(2);
		s.addNum(6);
		int[][] res = s.getIntervals();
		for(int i=0; i<res.length; i++) {
			for(int j=0; j<res[0].length; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}

	}
	
	public static class SummaryRanges {
		public static class Interval{
			int start;
			int end;
			Interval(int s, int e){
				start = s;
				end = e;
			}
		}
	    
	    ArrayList<Interval> list;
	    public SummaryRanges() {
	        list = new ArrayList<>();
	    }
	    
	    public void addNum(int val) {
	        int idx = getIndex(val);
	        if(idx == -1)
	            return;
	        Interval newInt = new Interval(val, val);
	        //check with left
	        Interval left;
	        if(idx > 0){
	            left = list.get(idx - 1);
	            if(left.end + 1 == val){
	                left.end = val;
	                newInt = left;
	            }
	        }
	        //check with right
	        Interval right;
	        if(idx < list.size()){
	            right = list.get(idx);
	            if(right.start - 1 == val){
	                right.start = val;
	                newInt = right;
	            }
	        }
	        //check for insert or not
	        if(newInt.start == val && newInt.end == val){
	            list.add(idx, newInt);
	        }else{
	            left = idx > 0 ? list.get(idx - 1) : null;
	            right = idx < list.size() ? list.get(idx) : null;
	            if(left != null && right != null && left.end == right.start){
	                left.end = right.end;
	                list.remove(right);
	            }
	        }
	    }
	    
	    public int[][] getIntervals() {
	        int c = 0;
	        int[][] res = new int[list.size()][2];
	        for (Interval i: list){
	            res[c][0]=i.start;
	            res[c][1]=i.end;
	            c++;
	        }
	        return res;
	    }
	    
	    public int getIndex(int val){
	        if(list.size() == 0){
	            return 0;
	        }
	        int left = 0;
	        int right = list.size();
	        while(left < right){
	            int mid = left + (right - left)/2;
	            Interval mInt = list.get(mid);
	            if(mInt.start <= val && mInt.end >= val){
	                return -1;
	            }
	            else if(mInt.end < val){
	                left = mid + 1;
	            }else{
	                right = mid;
	            }
	        }
	        return right;
	    } 
	    
	}

}
