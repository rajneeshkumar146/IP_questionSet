package may31;

import java.util.ArrayList;

public class employee_free_time {

	// make interval tree c++ stack and queue class 1

	static class interval {

		public int start;
		public int end;
		public interval left;
		public interval right;

		public interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

	}

	public static void add(interval root, interval node) {
		if (node.start <= root.start && node.end >= root.end || node.start >= root.start && node.end <= root.end
				|| node.start < root.start && node.end >= root.start
				|| root.start < node.start && root.end >= node.start) {
			root.start = Math.min(root.start, node.start);
			root.end = Math.max(root.end, node.end);
			return;
		} else if (node.end < root.start) {
			if (root.left == null) {
				root.left = node;
				return;
			} else {
				add(root.left, node);
			}
		} else {
			if (root.right == null) {
				root.right = node;
				return;
			} else {
				add(root.right, node);
			}
		}
	}

	public static ArrayList<interval> intervals = new ArrayList<>();

	public static void fill(interval root) {
		if (root == null) {
			return;
		}

		fill(root.left);
		intervals.add(root);
		fill(root.right);
	}

	public static ArrayList<interval> employeeFreeTime(int[][][] schedule) {

		interval root = null;

		for (int employee = 0; employee < schedule.length; employee++) {
			for (int timeperiods = 0; timeperiods < schedule[employee].length; timeperiods++) {
				interval interval = new interval(schedule[employee][timeperiods][0],
						schedule[employee][timeperiods][1]);
				if (root == null) {
					root = interval;
				} else {
					add(root, interval);
				}
			}
		}

		fill(root);
		ArrayList<interval> ans = new ArrayList<>();
		for (int i = 1; i < intervals.size(); i++) {
			interval free = new interval(intervals.get(i - 1).end, intervals.get(i).start);
			ans.add(free);
		}

		return ans;

	}

	public static void main(String[] args) {
		int[][][] schedule = { { { 1, 2 }, { 5, 6 } }, { { 1, 3 } }, { { 4, 10 } } };
		employeeFreeTime(schedule);
	}
}
