package Tree;

public class Perfect_Binary_Tree {

	private static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	public static boolean isPerfectRec(Node node, int d, int level) {
		if (node == null)
			return true;
		if (level + 1 > d)
			return false;
		if (node.left == null && node.right == null)
			return ((level + 1) == d);
		else if (node.left == null || node.right == null)
			return false;
		return isPerfectRec(node.left, d, level + 1) && isPerfectRec(node.right, d, level + 1);
	}
}
