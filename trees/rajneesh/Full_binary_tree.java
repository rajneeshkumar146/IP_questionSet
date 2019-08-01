package Tree;

public class Full_binary_tree {

	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	boolean isFullTree(Node node) {
		if (node == null)
			return true;
		if (node.left == null && node.right == null)
			return true;
		if (node.left != null && node.right != null)
			return isFullTree(node.left) && isFullTree(node.right);
		return false;
	}
}
