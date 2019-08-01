package recursion;

import java.util.*;

;

class Solution {
	public List<List<Integer>> permute(int[] nums) {
		return helper(nums, nums.length, nums.length);
	}

	private List<List<Integer>> result = new ArrayList<List<Integer>>();

	private List<List<Integer>> helper(int[] nums, int n, int k) {
		if (k == 1) {
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				list.add(nums[i]);
			}
			result.add(list);
		}

		for (int i = 0; i < k; i++) {
			int tmp = nums[i];
			nums[i] = nums[k - 1];
			nums[k - 1] = tmp;

			helper(nums, n, k - 1);
			tmp = nums[i];
			nums[i] = nums[k - 1];
			nums[k - 1] = tmp;
		}

		return result;
	}
}