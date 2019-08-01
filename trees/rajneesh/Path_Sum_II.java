package Tree;

import java.util.LinkedList;
import java.util.List;

public class Path_Sum_II {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if (root == null)
			return new LinkedList<>();

		if (root.left == null && root.right == null && sum - root.val == 0) {
			List<List<Integer>> base = new LinkedList<>();
			List<Integer> ans = new LinkedList<>();
			ans.add(root.val);
			base.add(ans);
			return base;
		}

		List<List<Integer>> ans = new LinkedList<>();

		List<List<Integer>> left = pathSum(root.left, sum - root.val);
		for (List<Integer> arr : left) {
			arr.add(0, root.val);
			ans.add(arr);
		}

		List<List<Integer>> right = pathSum(root.right, sum - root.val);
		for (List<Integer> arr : right) {
			arr.add(0, root.val);
			ans.add(arr);
		}

		return ans;

	}

}
