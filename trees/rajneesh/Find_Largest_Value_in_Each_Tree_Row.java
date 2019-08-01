package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Find_Largest_Value_in_Each_Tree_Row {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static List<Integer> largestValues(TreeNode root) {
		if (root == null)
			return new LinkedList<>();
		Queue<TreeNode> que = new LinkedList<>();
		que.add(root);

		List<Integer> ans = new LinkedList<>();

		while (que.size() > 0) {
			int size = que.size();
			int max = Integer.MIN_VALUE;

			while (size-- > 0) {
				TreeNode node = que.poll();
				max = Math.max(max, node.val);

				if (node.left != null)
					que.add(node.left);
				if (node.right != null)
					que.add(node.right);

			}
			ans.add(max);
		}

		return ans;

	}
}
