package Tree;

public class Check_for_BST {
	private static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	class pair {
		int min = (int) 1e6;
		int max = (int) -1e6;
		boolean bst = true;

		pair(int min, int max, boolean bst) {
			this.min = min;
			this.max = max;
			this.bst = bst;
		}

		pair() {

		}
	}

	int isBST(Node root) {
		return isBST_(root).bst ? 1 : 0;
	}

	pair isBST_(Node root) {
		if (root == null)
			return new pair();
		if (root.left == null && root.right == null)
			return new pair(root.data, root.data, true);

		pair left = isBST_(root.left);
		pair right = isBST_(root.right);

		int min = Math.min(left.min, Math.min(right.min, root.data));
		int max = Math.max(left.max, Math.max(right.max, root.data));

		if (left.bst && right.bst && right.min > root.data && left.max < root.data) {
			return new pair(min, max, true);
		}

		return new pair(min, max, false);

	}

}
