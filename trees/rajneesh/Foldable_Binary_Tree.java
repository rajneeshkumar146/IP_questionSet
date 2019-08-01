package Tree;

public class Foldable_Binary_Tree {
	private static class Node {
		int data;
		Node left, right;

		Node(int key) {
			data = key;
			left = right = null;
		}
	}

	public static boolean isFoldable(Node root) {
		if (root == null)
			return true;
		return isFoldable_(root.left, root.right);
	}

	public static boolean isFoldable_(Node node1, Node node2) {
		if (node1 == null && node2 == null)
			return true;

		if (node1 != null && node2 != null)
			return isFoldable_(node1.left, node2.right) && isFoldable_(node1.right, node2.left);
		return false;

	}

}
