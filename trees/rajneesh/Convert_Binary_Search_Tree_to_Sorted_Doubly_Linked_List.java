package Tree;

public class Convert_Binary_Search_Tree_to_Sorted_Doubly_Linked_List {

	public static class Node {
		int val;
		Node left;
		Node right;

		Node(int x) {
			val = x;
		}
	}

	public Node treeToDoublyList(Node root) {

		head = null;
		prev = null;
		treeToDoublyList_(root);
		if (head != null) {
			prev.right = head;
			head.left = prev;
		}
		return head;

	}

	Node prev = null;
	Node head = null;

	public void treeToDoublyList_(Node node) {
		if (node == null)
			return;

		Node left = node.left;
		Node right = node.right;

		treeToDoublyList_(left);
		if (head == null) {
			head = node;
		} else {
			prev.right = node;
			node.left = prev;
		}
		prev = node;

		treeToDoublyList_(right);

	}

}
