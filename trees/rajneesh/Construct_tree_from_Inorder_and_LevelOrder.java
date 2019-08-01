package Tree;

public class Construct_tree_from_Inorder_and_LevelOrder {

	private static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	public static Node construcTree(int arr[], int n) {
		Node[] tree = new Node[n];
		Node root = null;

		for (int i = 0; i < arr.length; i++)
			tree[i] = new Node(i);

		for (int i = 0; i < n; i++) {
			if (arr[i] == -1)
				root = tree[i];
			else {
				if (tree[arr[i]].left == null)
					tree[arr[i]].left = tree[i];
				else if (tree[arr[i]].right == null)
					tree[arr[i]].right = tree[i];
			}
		}
		return root;
	}

}
