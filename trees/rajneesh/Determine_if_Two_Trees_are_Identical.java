package Tree;

public class Determine_if_Two_Trees_are_Identical {

	private static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	static boolean isIdentical(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 != null && root2 != null)
			return root1.data == root2.data && isIdentical(root1.left, root2.left)
					&& isIdentical(root1.right, root2.right);
		return false;
	}

}
