package Tree;

public class Is_Binary_Tree_Heap {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	boolean isHeap(Node tree) {
		if (tree == null)
			return true;
		if (tree.left == null && tree.right == null)
			return true;
		if (tree.data < tree.left.data || tree.data < tree.right.data)
			return false;

		return isHeap(tree.left) && isHeap(tree.right);

	}
}
