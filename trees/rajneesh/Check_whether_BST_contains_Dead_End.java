package Tree;

public class Check_whether_BST_contains_Dead_End {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	// for dead end set range between 1 to infinity.
	// when we go to left [1,rooot.data-1]
	// when we go to right [rooot.data+1,infinity]

	public static boolean isDeadEnd(Node root) {
		return isDeadEnd_(root, 1, 1000000);
	}

	public static boolean isDeadEnd_(Node root, int Lrange, int Rrange) {
		if (root == null)
			return false;

		if (Lrange == Rrange)
			return true;
		return isDeadEnd_(root.left, Lrange, root.data - 1) || isDeadEnd_(root.right, root.data + 1, Rrange);

	}

}
