package pep_sns;

import java.util.ArrayList;
import java.util.Collections;

public class merge_intervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		int[][] res = merge(intervals);
		for(int i=0; i<res.length; i++) {
			System.out.println(res[i][0] + " " + res[i][1]);
		}
	}
	
	public static class Intervals implements Comparable<Intervals>{
        int start;
        int end;
        Intervals(int s, int e){
            start = s;
            end = e;
        }
        @Override
        public int compareTo(Intervals o){
            return this.start - o.start;
        }
    }
    public static int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return new int[0][0];
        }
        if(intervals.length == 1){
            return intervals;
        }
        ArrayList<Intervals> list = new ArrayList<>();
        for(int i=0; i<intervals.length; i++){
            list.add(new Intervals(intervals[i][0], intervals[i][1]));
        }
        Collections.sort(list);
        ArrayList<Intervals> ans = new ArrayList<>();
        ans.add(list.get(0));
        for(int i=1; i<list.size(); i++){
            if(ans.get(ans.size() - 1).end < list.get(i).start){
                ans.add(list.get(i));
            }else{
                ans.get(ans.size() - 1).end = Math.max(ans.get(ans.size() - 1).end, list.get(i).end);
            }
        }
        int[][] result = new int[ans.size()][2];
        for(int i=0; i<ans.size(); i++){
            result[i][0] = ans.get(i).start;
            result[i][1] = ans.get(i).end;
        }
        return result;
    }

}
