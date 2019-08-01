package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Permutation_2 {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2 };
		List<List<Integer>> ans = permuteUnique(nums);
		for (List<Integer> list : ans) {
			System.out.println(list);
		}
	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> tempans = new ArrayList<>();
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < nums.length; i++) {
			list.addLast(nums[i]);
		}
		permuteUnique1(list, ans, tempans, new HashSet<Integer>());
		return ans;
	}

	public static void permuteUnique1(LinkedList<Integer> nums, List<List<Integer>> ans, List<Integer> tempans,
			HashSet<Integer> set) {
		if (nums.size() == 0) {
			List<Integer> br = new ArrayList<>(tempans);
			ans.add(br);
			return;
		}

		set = new HashSet<>();
		for (int i = 0; i < nums.size(); i++) {
			int rem = nums.get(i);
			if (set.contains(rem) == false) {
				set.add(rem);
				nums.remove(i);
				tempans.add(rem);
				permuteUnique1(nums, ans, tempans, set);
				tempans.remove(tempans.size() - 1);
				nums.add(i, rem);
			}
		}
	}

	private static void getperp(String ques, String asf, boolean[] arr) {
		if (ques.length() == 0) {
			System.out.println(asf);
			return;
		}
		arr = new boolean[25];
		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			if (arr[(int) (ch - 'a')] == false) {
				arr[(int) (ch - 'a')] = true;
				getperp(ques.substring(0, i) + ques.substring(i + 1), asf + ch, arr);
			}
		}
	}
}
