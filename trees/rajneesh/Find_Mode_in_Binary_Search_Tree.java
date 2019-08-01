package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Find_Mode_in_Binary_Search_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	HashMap<Integer, Integer> map = new HashMap<>();
	int max = 0;

	public int[] findMode(TreeNode root) {
		if (root == null)
			return new int[0];

		findMode_(root);
		List<Integer> keys = new ArrayList<>();
		for (int i : map.keySet()) {
			if (map.get(i) == max) {
				keys.add(i);
			}
		}

		int[] ans = new int[keys.size()];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = keys.get(i);
		}
		return ans;
	}

	public void findMode_(TreeNode node) {
		map.put(node.val, map.getOrDefault(node.val, 0) + 1);
		max = Math.max(map.get(node.val), max);

		if (node.left != null) {
			findMode_(node.left);
		}

		if (node.right != null) {
			findMode_(node.right);
		}
	}
}
