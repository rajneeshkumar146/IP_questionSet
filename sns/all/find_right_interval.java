package pep_sns;

import java.util.Arrays;

public class find_right_interval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] intervals = { { 3, 4 }, { 2, 3 }, { 1, 2 } };
		int[] results = findRightInterval(intervals);
		for(int val: results)
			System.out.print(val + " ");
	}

	public static class Pair implements Comparable<Pair> {
		int start;
		int end;
		int index;

		Pair(int s, int e, int i) {
			this.start = s;
			this.end = e;
			this.index = i;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.start - o.start;
		}
	}

	public static int[] findRightInterval(int[][] intervals) {
		if(intervals.length == 0)
            return new int[0];
		int[] results = new int[intervals.length];
		Pair[] obj = new Pair[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			obj[i] = new Pair(intervals[i][0], intervals[i][1], i);
		}
		Arrays.sort(obj);

		for (int i = 0; i < intervals.length; i++) {
			int tosearch = obj[i].end;
			int left = 0;
			int right = intervals.length - 1;
			boolean flag = false;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (obj[mid].start >= tosearch && obj[mid - 1].start < tosearch) {
					results[obj[i].index] = obj[mid].index;
					flag = true;
					break;
				}
				if (obj[mid].start >= tosearch) {
					right = mid - 1;
				} else if (obj[mid].start < tosearch) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			if (!flag) {
				results[obj[i].index] = -1;
			}
		}
		results[obj[intervals.length - 1].index] = -1;
		return results;
	}

}
