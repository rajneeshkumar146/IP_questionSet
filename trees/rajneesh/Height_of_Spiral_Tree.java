package Tree;

public class Height_of_Spiral_Tree {

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	public int treeHeight(Node root) {
		// Write your code here
		if (root == null)
			return 0;
		if (root.left != null && root.left.right == root && root.right != null && root.right.left == root)
			return 1;
		return Math.max(treeHeight(root.left), treeHeight(root.right)) + 1;
	}

}
