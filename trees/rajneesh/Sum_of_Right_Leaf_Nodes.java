package Tree;

public class Sum_of_Right_Leaf_Nodes {

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	public int rightLeafSum(Node root) {
		return rightLeafSum_(root, false);
	}

	public int rightLeafSum_(Node root, boolean isright) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null && isright)
			return root.data;
		return rightLeafSum_(root.left, false) + rightLeafSum_(root.right, true);
	}
}
