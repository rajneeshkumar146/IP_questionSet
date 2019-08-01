package Tree;

import java.util.LinkedList;

import Tree.pth_common_ancestor_in_BST.Node;

public class Populating_Next_Right_Pointers_in_Each_Node {
	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}

	public Node connect(Node root) {
		if (root == null)
			return root;
		LinkedList<Node> que = new LinkedList<>();
		que.addLast(root);

		while (!que.isEmpty()) {
			int size = que.size();
			Node temp = new Node(); // dummy node only bypass null check
			while (size-- > 0) {
				Node nn = que.removeFirst();
				if (nn.left != null)
					que.addLast(nn.left);
				if (nn.right != null)
					que.addLast(nn.right);

				temp.next = nn;
				temp = nn;

			}
			temp.next = null;
		}

		return root;
	}

}
