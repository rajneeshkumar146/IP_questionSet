package Tree;

public class Construct_Binary_Tree_from_Parent_Array {

	class Node {
		int data;
		Node left, right;

		Node(int key) {
			data = key;
			left = right = null;
		}
	}

	public Node construcTree(int arr[], int n) {
		Node[] tree = new Node[arr.length];
		Node root = null;
		for (int i = 0; i < arr.length; i++) {
			tree[i] = new Node(i);
			if (arr[i] == -1)
				root = tree[i];
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1)
				continue;

			if (tree[arr[i]].left == null)
				tree[arr[i]].left = tree[i];

			if (tree[arr[i]].right == null)
				tree[arr[i]].right = tree[i];
		}
		return root;
	}

}