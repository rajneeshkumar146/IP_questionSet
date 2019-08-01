package Tree;

public class Expression_Tree {
	class Node {
		String data;
		Node left, right;

		Node(String data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public int evalTree(Node root) {
		if (root.left == null && root.right == null) {
			return Integer.parseInt(root.data);
		}

		int left = evalTree(root.left);
		int right = evalTree(root.right);

		return operation(root.data, left, right);
	}

	public int operation(String str, int val1, int val2) {
		if (str.equals("*")) {
			return val1 * val2;
		} else if (str.equals("+")) {
			return val1 + val2;
		} else if (str.equals("-")) {
			return val1 - val2;
		} else {
			return val2 / val1;
		}
	}

}
