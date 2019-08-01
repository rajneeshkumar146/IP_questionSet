package Tree;

public class Ancestors_in_Binary_Tree {
	private static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	public static boolean printAncestors(Node node, int x) {
		if (node == null)
			return false;
		if (node.data == x) {
			// System.out.print(x+" ");
			return true;
		}

		if (printAncestors(node.left, x)) {
			System.out.print(node.data + " ");
			return true;
		}

		if (printAncestors(node.right, x)) {
			System.out.print(node.data + " ");
			return true;

		}

		return false;

	}

}
