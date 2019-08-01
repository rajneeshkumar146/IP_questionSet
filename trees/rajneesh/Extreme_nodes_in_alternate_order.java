package Tree;

import java.util.LinkedList;

public class Extreme_nodes_in_alternate_order {
	class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = null;
			right = null;
		}
	}

	public void printExtremeNode(Node node) {
		if (node == null)
			return;

		LinkedList<Node> st1 = new LinkedList<>();
		LinkedList<Node> st2 = new LinkedList<>();

		st1.addLast(node);

		while (!st1.isEmpty() || !st2.isEmpty()) {
			boolean flag = false;

			while (!st1.isEmpty()) {
				Node nn = st1.removeFirst();

				if (!flag) {
					System.out.print(nn.data + " ");
					flag = true;
				}

				if (nn.right != null) {
					st2.addFirst(nn.right);
				}
				if (nn.left != null) {
					st2.addFirst(nn.left);
				}

			}

			flag = false;
			while (!st2.isEmpty()) {
				Node nn = st2.removeFirst();

				if (!flag) {
					System.out.print(nn.data + " ");
					flag = true;
				}

				if (nn.left != null) {
					st1.addFirst(nn.left);
				}
				if (nn.right != null) {
					st1.addFirst(nn.right);
				}

			}

		}

	}

}
