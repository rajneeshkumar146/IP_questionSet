package graphs;

import java.util.ArrayList;
import java.util.HashSet;

public class IncreasingSubsequences {

	public static void main(String[] args) {

		int[] nums = { 4, 6, 7, 7 };

		ArrayList<ArrayList<Integer>> list = findSubsequences(nums);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

	public static ArrayList<ArrayList<Integer>> findSubsequences(int[] nums) {

		if (nums == null || nums.length == 0) {
			return new ArrayList<ArrayList<Integer>>();
		}
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		dfs(nums, 0, new ArrayList<Integer>(), ret);
		return ret;

	}

	public static void dfs(int[] ar, int pos, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ret) {

		if (list.size() > 1) {
			ret.add(new ArrayList<Integer>(list));
		}

		HashSet<Integer> set = new HashSet<Integer>();

		for (int i = pos; i < ar.length; i++) {
			if (!set.add(ar[i])) {
				continue;
			}
			if (list.isEmpty() || ar[i] >= list.get(list.size() - 1)) {
				list.add(ar[i]);
				dfs(ar, i + 1, list, ret);
			}
			list.remove(list.size() - 1);
		}

	}

}
