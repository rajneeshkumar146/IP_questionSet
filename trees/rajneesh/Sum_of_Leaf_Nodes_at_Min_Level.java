package Tree;

import java.util.LinkedList;

public class Sum_of_Leaf_Nodes_at_Min_Level {
	private static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	public int minLeafSum(Node root) {
		LinkedList<Node> que = new LinkedList<>();
		que.addLast(root);

		boolean flag = false;
		int sum = 0;
		while (!flag && !que.isEmpty()) {
			int size = que.size();

			while (size-- > 0) {
				Node pnode = que.removeFirst();
				if (pnode.left == null && pnode.right == null) {
					sum += pnode.data;
					flag = true;
				}

				if (pnode.left != null)
					que.addLast(pnode.left);
				if (pnode.right != null)
					que.addLast(pnode.right);
			}
		}

		return sum;

	}
}
