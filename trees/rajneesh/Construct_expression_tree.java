package Tree;

import java.util.Stack;

public class Construct_expression_tree {
	private static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	public static Node constructTree(char postfix[]) {
		Stack<Node> st = new Stack<Node>();
		Node t, t1, t2;

		for (int i = 0; i < postfix.length; i++) {
			if (!isOperator(postfix[i])) {
				t = new Node(postfix[i]);
				st.push(t);
			} else {
				t = new Node(postfix[i]);

				t1 = st.peek();
				st.pop();

				t2 = st.peek();
				st.pop();

				t.left = t1;
				t.right = t2;

				st.push(t);
			}
		}

		t = st.peek();
		st.pop();

		return t;
	}

	public static boolean isOperator(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^')
			return true;

		return false;
	}

}
