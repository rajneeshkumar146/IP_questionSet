package Tree;

import java.util.LinkedList;

public class Minimum_Depth_of_Binary_Tree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;

		LinkedList<TreeNode> que = new LinkedList<>();
		LinkedList<Integer> lev = new LinkedList<>();

		que.addLast(root);
		lev.addLast(1);
		int minDepth = -1;

		while (!que.isEmpty() && minDepth == -1) {
			int size = que.size();

			while (size-- > 0) {
				TreeNode proc = que.removeFirst();
				int le = lev.removeFirst();
				if (proc.left == null && proc.right == null) {
					minDepth = le;
					break;
				}
				if (proc.left != null) {
					que.addLast(proc.left);
					lev.addLast(le + 1);
				}
				if (proc.right != null) {
					que.addLast(proc.right);
					lev.addLast(le + 1);
				}
			}
		}
		return minDepth;

	}
}
