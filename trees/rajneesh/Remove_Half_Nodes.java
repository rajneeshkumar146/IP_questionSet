package Tree;

public class Remove_Half_Nodes {
	public static class Node {
		int val;
		Node left;
		Node right;

		Node(int x) {
			val = x;
		}
	}

	public Node removeHalfNodes(Node root) {
		if (root == null)
			return null;
		root.left = removeHalfNodes(root.left);
		root.right = removeHalfNodes(root.right);
		if (root.left == null && root.right == null)
			return root;
		if (root.left == null && root.right != null)
			return root.right;
		if (root.right == null && root.left != null)
			return root.left;
		return root;

	}
}
