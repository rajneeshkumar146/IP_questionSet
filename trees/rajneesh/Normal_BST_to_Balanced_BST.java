package Tree;

public class Normal_BST_to_Balanced_BST {
	class Node {
		int value;
		Node left, right;

		Node(int d) {
			value = d;
			left = right = null;
		}
	}

	int len = 0;

	Node buildBalancedTree(Node root) {
		Node[] arr = new Node[1000];
		len = 0;
		inorder(root, arr);
		int high = len - 1;
		return build(arr, 0, high);
	}

	void inorder(Node root, Node[] arr) {
		if (root == null)
			return;

		inorder(root.left, arr);
		arr[len++] = root;
		inorder(root.right, arr);
	}

	Node build(Node[] arr, int low, int high) {
		if (high < low)
			return null;
		int mid = (low + high) / 2;
		Node root = arr[mid];
		root.left = build(arr, low, mid - 1);
		root.right = build(arr, mid + 1, high);

		return root;
	}

}
