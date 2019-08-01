package Tree;

public class Leaf_at_same_level {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	boolean check(Node root) {
		return check_(root) != -1 ? true : false;
	}

	int check_(Node root) {
		if (root == null)
			return -1;
		if (root.left == null && root.right == null)
			return 1;

		int left = check_(root.left);
		int right = check_(root.right);

		if (root.left != null && root.right != null && left != -1) {
			if (left == right)
				return Math.max(left, right) + 1;
		}
		if (root.right == null && left != -1)
			return left + 1;
		if (root.left == null && right != -1)
			return right + 1;
		return -1;
	}

}
