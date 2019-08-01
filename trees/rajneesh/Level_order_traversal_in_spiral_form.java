package Tree;

import java.util.Stack;

public class Level_order_traversal_in_spiral_form {
	static class Node {
		int data;
		Node left, right;

		Node(int key) {
			data = key;
			left = right = null;
		}
	}

	void printSpiral(Node node) {
		// Your code here
		if (node == null)
			return;
		Stack<Node> s = new Stack<>();
		Stack<Node> s1 = new Stack<>();
		s.push(node);
		while (!s.isEmpty() || !s1.isEmpty()) {
			while (!s.isEmpty()) {
				Node temp = s.peek();
				s.pop();
				System.out.print(temp.data + " ");
				if (temp.right != null)
					s1.push(temp.right);
				if (temp.left != null)
					s1.push(temp.left);
			}
			while (!s1.isEmpty()) {
				Node temp = s1.peek();
				s1.pop();
				System.out.print(temp.data + " ");
				if (temp.left != null)
					s.push(temp.left);
				if (temp.right != null)
					s.push(temp.right);
			}
		}
	}

}
