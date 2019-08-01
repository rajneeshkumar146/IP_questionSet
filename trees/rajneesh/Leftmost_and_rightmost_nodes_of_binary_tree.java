package Tree;

import java.util.LinkedList;

public class Leftmost_and_rightmost_nodes_of_binary_tree {
	class Node {
		int data;
		Node left, right;

		Node(int key) {
			data = key;
			left = right = null;
		}
	}

	public static void printCorner(Node node) {
		LinkedList<Node> que = new LinkedList<>();
		que.addLast(node);

		while (!que.isEmpty()) {
			int size = que.size();
			Node nn = que.getFirst();
			if (size > 1)
				System.out.print(nn.data + " ");
			while (size-- > 0) {
				Node curr = que.removeFirst();
				nn = curr;
				if (curr.left != null)
					que.addLast(curr.left);
				if (curr.right != null)
					que.addLast(curr.right);
			}

			System.out.print(nn.data + " ");
		}
	}
}
