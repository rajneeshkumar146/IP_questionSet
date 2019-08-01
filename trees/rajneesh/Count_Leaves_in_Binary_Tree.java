package Tree;

public class Count_Leaves_in_Binary_Tree {

	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	int countLeaves(Node node) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return 1;
		return countLeaves(node.left) + countLeaves(node.right);
	}

}
