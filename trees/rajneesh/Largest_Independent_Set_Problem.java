package Tree;

public class Largest_Independent_Set_Problem {
	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	public int LISS(Node node) {
		// Write your code here
		if (node == null)
			return 0;
		int size_excl = LISS(node.left) + LISS(node.right);

		int size_incl = 1;
		if (node.left != null)
			size_incl += LISS(node.left.left) + LISS(node.left.right);
		if (node.right != null)
			size_incl += LISS(node.right.left) + LISS(node.right.right);
		return Math.max(size_excl, size_incl);

	}

	// method_02.=====================================================================
	class Counter {
		int ex;
		int in;

		Counter() {
		}

		Counter(int x, int y) {
			ex = x;
			in = y;
		}
	}

	public int LISS_(Node node) {
		Counter c = util(node);
		return c.ex > c.in ? c.ex : c.in;
	}

	int max(int a, int b) {
		return a > b ? a : b;
	}

	Counter util(Node node) {
		if (node == null) {
			return new Counter(0, 0);
		}
		Counter left = util(node.left);
		Counter right = util(node.right);
		int ex = max(max(left.in + right.in, left.in + right.ex), max(left.ex + right.in, left.ex + right.ex));
		int in = 1 + left.ex + right.ex;
		return new Counter(ex, in);
	}

}
