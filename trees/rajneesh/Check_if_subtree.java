package Tree;

public class Check_if_subtree {
	static class Tree {
		int data;
		Tree left, right;

		Tree(int d) {
			data = d;
			left = null;
			right = null;
		}
	}

	public static boolean isSubtree(Tree T, Tree S) {
		if (T != null && S == null)
			return true;
		if (T == null || S == null)
			return true;

		
		return isIdentical(isFind(T,S), S);
	}

	public static boolean isIdentical(Tree node, Tree node1) {
		if (node == null && node1 == null)
			return true;
		if (node == null || node1 == null)
			return false;

		return node.data == node1.data && isIdentical(node.left, node1.left) && isIdentical(node.right, node1.right);

	}

	public static Tree isFind(Tree node1, Tree node2) {
		if (node1 == null)
			return null;

		if (node1.data == node2.data)
			return node1;

		Tree left = isFind(node1.left, node2);
		if (left != null)
			return left;
		Tree right = isFind(node1.right, node2);
		if (right != null)
			return right;

		return null;
	}

}
