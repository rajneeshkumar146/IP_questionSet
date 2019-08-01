package Tree;

import java.util.LinkedList;

public class Check_Completeness_of_a_Binary_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/*
	 * Note that after we meet the first null node we cannot have a non-null
	 * node after that otherwise the tree is imbalance
	 */

	public boolean isCompleteTree(TreeNode root) {
		LinkedList<TreeNode> que = new LinkedList<>();
		que.addLast(root);

		boolean encounterNull = false;

		while (!que.isEmpty()) {
			TreeNode node = que.removeFirst();
			if (node == null) { // once null encountered then again null will
								// not encountered.
				encounterNull = true;
			} else {
				if (encounterNull == true) { // after_null_there_is_a_element_encountered_means_tree_is_not_complete.

					return false;
				}

				que.addLast(node.left);
				que.addLast(node.right);

			}

		}

		return true;

	}
}
