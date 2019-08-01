package Tree;

public class Sum_Tree {

	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	boolean isSumTree(Node node) {
		return isSumTree_(node).issum;
	}

	class pair {
		boolean issum = false;
		int sum = 0;

		pair() {

		}

		pair(boolean issum, int sum) {
			this.issum = issum;
			this.sum = sum;
		}
	}

	pair isSumTree_(Node node) {
		if (node == null)
			return new pair(true, 0);
		if (node.left == null && node.right == null)
			return new pair(true, node.data);
		pair mp = new pair();
		pair left = isSumTree_(node.left);
		pair right = isSumTree_(node.right);
		if (!left.issum || !right.issum)
			return mp;

		mp.sum = left.sum + right.sum + node.data;
		if (left.sum + right.sum == node.data)
			mp.issum = true;
		return mp;
	}
}
