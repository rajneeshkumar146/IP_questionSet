package Tree;

public class Maximum_sum_of_Non_adjacent_nodes {

	class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	static class pair {
		int first;
		int second;

		pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	static pair getVal(Node root) {
		if (root == null) {
			pair s = new pair(0, 0);
			return s;
		}
		pair sum1 = getVal(root.left);
		pair sum2 = getVal(root.right);
		pair sum = new pair(0, 0);
		sum.first = sum1.second + sum2.second + root.data;
		sum.second = Math.max(sum1.first, sum1.second) + Math.max(sum2.first, sum2.second);
		return sum;
	}

	static int getMaxSum(Node root) {
		// add your code here
		pair sum = getVal(root);
		return Math.max(sum.first, sum.second);
	}

}
