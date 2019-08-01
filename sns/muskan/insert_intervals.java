package pep_sns;

import java.util.ArrayList;

public class insert_intervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
		int[] newInterval = { 4, 8 };
		int[][] result = insert(intervals, newInterval);
		for (int[] arr : result) {
			for (int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println();
		}

	}

	private static class Interval {
		int start;
		int end;

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public static int[][] insert(int[][] intervals, int[] newInterval) {
		ArrayList<Interval> list = new ArrayList<>();
		for (int i = 0; i < intervals.length; i++) {
			if (intervals[i][1] < newInterval[0]) {
				list.add(new Interval(intervals[i][0], intervals[i][1]));
			} else if (intervals[i][0] > newInterval[1]) {
				list.add(new Interval(newInterval[0], newInterval[1]));
				newInterval[0] = intervals[i][0];
				newInterval[1] = intervals[i][1];
			} else if (intervals[i][0] < newInterval[1] || intervals[i][1] > newInterval[0]) {
				newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
				newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
			}
		}
		list.add(new Interval(newInterval[0], newInterval[1]));
		int[][] result = new int[list.size()][2];
		int c = 0;
		for (Interval i : list) {
			result[c][0] = i.start;
			result[c][1] = i.end;
			c++;
		}
		return result;
	}

}
