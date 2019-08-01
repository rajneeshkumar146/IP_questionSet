package Tree;

public class Number_of_Turns_in_Binary_Tree {
	class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	int NumberOfTurn(Node root, int first, int second) {
		max = 0;
		Node node = ancestor(root, first, second);

		if (node.data == first) {
			return depth(node, second);
		} else if (node.data == second) {
			return depth(node, first);
		}

		return depth(node, first) + depth(node, second) + 1;

	}

	int depth(Node node, int key) {
		max = 0;
		turns(node, key, 0, false, false);
		return max;
	}

	int max = 0;

	void turns(Node node, int key, int count, boolean isLeft, boolean isRight) {
		if (node == null)
			return;
		if (node.data == key) {
			max = Math.max(max, count);
		}

		int temp = isRight ? count + 1 : count;
		turns(node.left, key, temp, true, false);

		temp = isLeft ? count + 1 : count;
		turns(node.right, key, temp, false, true);

	}

	public Node ancestor(Node node, int first, int second) {
		if (node == null || node.data == first || node.data == second)
			return node;

		Node left = ancestor(node.left, first, second);
		Node right = ancestor(node.right, first, second);

		if (left != null && right != null)
			return node;

		return left != null ? left : right;

	}
}
