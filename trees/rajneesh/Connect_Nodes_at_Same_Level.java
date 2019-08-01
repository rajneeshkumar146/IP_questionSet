package Tree;

import java.util.LinkedList;

public class Connect_Nodes_at_Same_Level {
	static class Node {
		int data;
		Node left, right, nextRight;

		Node(int item) {
			data = item;
			left = right = nextRight = null;

		}
	}

	void connect(Node root) {

		LinkedList<Node> que = new LinkedList<>();
		que.addLast(root);

		while (!que.isEmpty()) {
			int size = que.size();
			while (size-- > 0) {
				Node curr = que.removeFirst();
				if (size != 0) {
					curr.nextRight = que.getFirst();
				}
				if (curr.left != null)
					que.addLast(curr.left);
				if (curr.right != null)
					que.addLast(curr.right);
			}
		}

	}
}
