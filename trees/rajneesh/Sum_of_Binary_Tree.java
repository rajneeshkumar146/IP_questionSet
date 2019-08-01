package Tree;

public class Sum_of_Binary_Tree {

	private static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	public int sumBT(Node root) {
		if (root == null)
			return 0;

		return root.data + sumBT(root.left) + sumBT(root.right);
	}

}
