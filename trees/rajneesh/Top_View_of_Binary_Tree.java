package Tree;

import java.util.LinkedList;

public class Top_View_of_Binary_Tree {

	private static class TreeNode {
		int key;
		TreeNode left, right;

		public TreeNode(int data) {
			this.key = data;
		}
	}

	public void printTopView(TreeNode root) {
		LinkedList<Node> queN = new LinkedList<>();
		queN.addLast(new Node(root, 0));

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		while (!queN.isEmpty()) {
			Node proc = queN.removeFirst();
			if (proc.val < min || proc.val > max) {
				System.out.print(proc.node.key + " ");
				min = Math.min(min, proc.val);
				max = Math.max(max, proc.val);
			}

			if (proc.node.left != null)
				queN.addLast(new Node(proc.node.left, proc.val - 1));
			if (proc.node.right != null)
				queN.addLast(new Node(proc.node.right, proc.val + 1));

		}

	}

	public static class Node {
		int val;
		TreeNode node;

		public Node(TreeNode node, int index) {
			this.val = index;
			this.node = node;
		}
	}
}
