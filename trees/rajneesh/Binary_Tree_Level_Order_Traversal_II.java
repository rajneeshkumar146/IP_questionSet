package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Binary_Tree_Level_Order_Traversal_II {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		DFSSolution(root, ans, 0);
		return ans;
	}

	public static void DFSSolution(TreeNode node, List<List<Integer>> ans, int level) {
		if (node == null)
			return;

		if (level >= ans.size())
			ans.add(0, new ArrayList<Integer>());

		DFSSolution(node.left, ans, level + 1);
		DFSSolution(node.right, ans, level + 1);

		ans.get(ans.size() - level - 1).add(node.val);
	}

	public static void BFSSolution(TreeNode root, List<List<Integer>> wrapList) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelNum = queue.size();
			List<Integer> subList = new LinkedList<Integer>();
			for (int i = 0; i < levelNum; i++) {
				if (queue.peek().left != null)
					queue.offer(queue.peek().left);
				if (queue.peek().right != null)
					queue.offer(queue.peek().right);
				subList.add(queue.poll().val);
			}
			wrapList.add(0, subList);
		}
	}
}

// 3 9 20 null null 15 7
// [[9,15,7],[20],[3]]
// [[15,7],[9,20],[3]]