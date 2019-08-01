package Tree;

import java.util.LinkedList;

public class Diagonal_Traversal_of_Binary_Tree {

	private static class TreeNode {
		int data;
		TreeNode left, right;

		public TreeNode(int data) {
			this.data = data;
			left = right = null;
		}
	}

	public static void diagonalPrint(TreeNode root) {
		LinkedList<TreeNode> que = new LinkedList<>();
		que.addLast(root);
		while (!que.isEmpty()) {
			int size = que.size();
			TreeNode node = que.removeFirst();

			while (node != null) {
				System.out.print(node.data + " ");
				if (node.left != null) {// add in que for next diagonal
										// process.
					que.addLast(node.left);
				}
				node = node.right;// move forward in respective diagonal.

			}
		}
	}

}
