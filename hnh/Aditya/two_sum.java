package may27;

import java.util.ArrayList;
import java.util.Collections;

public class two_sum {

	class pair implements Comparable<pair> {
		public int data;
		public int index;

		pair(int data, int index) {
			this.data = data;
			this.index = index;
		}

		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return this.data - o.data;
		}

	}

	public ArrayList<Integer> twoSum(ArrayList<Integer> nums, int target) {

		ArrayList<pair> pv = new ArrayList<>();

		for (int i = 0; i < nums.size(); i++) {
			pair p = new pair(nums.get(i), i);
			pv.add(p);
		}

		Collections.sort(pv);

		int start = 0;
		int end = nums.size() - 1;

		ArrayList<Integer> ans = new ArrayList<>();
		while (start < end) {
			if (pv.get(start).data + pv.get(end).data == target) {
				if (pv.get(start).index > pv.get(end).index) {
					ans.add(pv.get(end).index);
					ans.add(pv.get(start).index);
					return ans;
				} else {
					ans.add(pv.get(start).index);
					ans.add(pv.get(end).index);
					return ans;
				}

			} else if (pv.get(start).data + pv.get(end).data > target) {
				end--;
			} else {
				start++;
			}
		}
		return ans;

	}

	public static void main(String[] args) {

	}

	// TODO Auto-generated method stub

}
