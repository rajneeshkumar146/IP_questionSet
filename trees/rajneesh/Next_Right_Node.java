package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Next_Right_Node {

	class Node {
		int data;
		Node left, right, parent;

		Node(int d) {
			data = d;
			left = right = parent = null;
		}
	}

	public static Node nextRight(Node root, int k) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		Node delimiter = null;
		q.add(delimiter);
		while (!q.isEmpty()) {
			Node curr = q.remove();
			if (curr != delimiter) {
				if (curr.data == k)
					return q.peek();
				if (curr.left != null)
					q.add(curr.left);
				if (curr.right != null)
					q.add(curr.right);
			} else {
				if (!q.isEmpty())
					q.add(delimiter);
			}
		}
		return null;
	}

}
