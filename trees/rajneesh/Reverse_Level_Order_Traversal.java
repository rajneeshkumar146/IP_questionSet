package Tree;

import java.util.LinkedList;

public class Reverse_Level_Order_Traversal {

	private static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	void reversePrint(Node node) {
		LinkedList<Node> que = new LinkedList<>();
		LinkedList<Node> st = new LinkedList<>();

		que.addLast(node);

		while (!que.isEmpty()) {
			int size = que.size();
			while (size-- > 0) {
				Node proc = que.removeFirst();
				st.addFirst(proc);

				if (proc.right != null)
					que.addLast(proc.right);
				if (proc.left != null)
					que.addLast(proc.left);

			}
		}

		while (!st.isEmpty()) {
			System.out.print(st.removeFirst().data + " ");
		}
	}
}
