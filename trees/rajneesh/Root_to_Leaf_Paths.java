package Tree;

public class Root_to_Leaf_Paths {
	class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	public void printPaths(Node root) {
		printPaths_(root, "");
	}

	public void printPaths_(Node root, String str) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			System.out.print(str + root.data + " #");
			return;
		}
		printPaths_(root.left, str + root.data + " ");
		printPaths_(root.right, str + root.data + " ");

	}
}
