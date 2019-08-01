package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Binary_Tree_Level_Order_Traversal {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> levelOrder(TreeNode node) {
		if (node == null)
			return new ArrayList<>();

		LinkedList<TreeNode> que = new LinkedList<>();
		que.addLast(node);
		que.addLast(null);

		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> arr = new ArrayList<>();

		while (que.size() != 1) {
			TreeNode nd = que.removeFirst();
			arr.add(nd.val);

			if (nd.left != null)
				que.addLast(nd.left);
			if (nd.right != null)
				que.addLast(nd.right);

			if (que.getFirst() == null) {
				que.removeFirst();
				que.addLast(null);
				ans.add(arr);
				arr = new ArrayList<>();
			}
		}
		return ans;

	}

}
