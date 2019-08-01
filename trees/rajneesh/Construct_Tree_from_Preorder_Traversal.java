package Tree;

public class Construct_Tree_from_Preorder_Traversal {

	private static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	Node constructTree(int n, int pre[], char preLN[]) {
		java.util.Stack<Node> stack = new java.util.Stack<>();
		Node root = new Node(pre[0]);
		stack.push(root);
		int i = 1;
		while (i < n && !stack.empty()) {
			Node node = stack.peek();
			Node newNode = new Node(pre[i]);
			if (node.left != null) {
				node.right = newNode;
				stack.pop();
			} else {
				node.left = newNode;
			}
			if (preLN[i] == 'N') {
				stack.push(newNode);
			}
			i++;
		}

		return root;
	}

}
