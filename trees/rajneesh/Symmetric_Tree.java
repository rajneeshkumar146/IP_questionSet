package Tree;

public class Symmetric_Tree {

	class Node {
		int data;
		Node left, right;

		Node(int data)
		 {
		     this.data = data;
		     left = right = null;
		 }
	}

	public static boolean isSymmetric(Node root) {
		if (root == null && (root.left == null && root.right == null))
			return true;

		return !isSymmetric_(root.left, root.right);
	}

	public static boolean isSymmetric_(Node n1, Node n2) {
		if (n1 == null && n2 == null)
			return false;
		else if (n1 == null || n2 == null)
			return true;
		else if (n1.data != n2.data)
			return true;

		boolean res = false;
		res = res || isSymmetric_(n1.left, n2.right);
		res = res || isSymmetric_(n1.right, n2.left);

		return res;

	}

}
