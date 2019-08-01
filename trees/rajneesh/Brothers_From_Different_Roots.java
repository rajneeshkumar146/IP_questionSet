package Tree;

import java.util.LinkedList;

public class Brothers_From_Different_Roots {

	private static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	public static int countPairs(Node node, Node node1, int x) {
		int count = 0;
		LinkedList<Node> que = new LinkedList<>();
		que.addLast(node);

		while (!que.isEmpty()) {
			Node proc = que.removeFirst();
			if (find(node1, x - proc.data))
				count++;
			if (proc.left != null)
				que.addLast(proc.left);
			if (proc.right != null)
				que.addLast(proc.right);
		}

		return count;

	}

	public static boolean find(Node node, int data) {
		while (node != null) {
			if (node.data < data)
				node = node.right;
			else if (node.data > data)
				node = node.left;
			else if (node.data == data)
				return true;
		}

		return false;

	}
}
