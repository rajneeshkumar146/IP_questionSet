package Tree;

import java.util.LinkedList;

public class Nodes_at_Odd_Levels {
	class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	public void nodeAtOdd(Node root) {

		class pair {
			int level = 0;;
			Node node = null;

			pair(Node node, int level) {
				this.node = node;
				this.level = level;
			}
		}
		;

		LinkedList<pair> que = new LinkedList<>();
		que.addLast(new pair(root, 1));

		while (!que.isEmpty()) {
			pair p = que.removeFirst();
			if ((p.level & 1) != 0) {
				System.out.print(p.node.data + " ");
			}

			if (p.node.left != null)
				que.addLast(new pair(p.node.left, p.level + 1));
			if (p.node.right != null)
				que.addLast(new pair(p.node.right, p.level + 1));
		}
	}

}
