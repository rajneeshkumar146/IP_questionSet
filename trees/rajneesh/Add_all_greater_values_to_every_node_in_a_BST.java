package Tree;

public class Add_all_greater_values_to_every_node_in_a_BST {

	public static void main(String[] args) {

	}

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	static void modify(Node root) {
		Node sum = new Node(0);
		solution(root, sum);
	}

	static void solution(Node root, Node sum) {
		if (root == null)
			return;

		solution(root.right, sum);
		sum.data += root.data;
		root.data = sum.data;
		solution(root.left, sum);
	}

}
