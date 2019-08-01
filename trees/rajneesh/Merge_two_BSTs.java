package Tree;

public class Merge_two_BSTs {

	class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	// method_01.========================================================================

	private static Node helper(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return null;

		}
		if (root1 == null) {
			return root2;
		}
		if (root2 == null) {
			return root1;
		}
		if (root1.data > root2.data) {
			Node right = root2.right;
			root2.right = null;

			root1.left = helper(root1.left, root2);
			helper(root1, right);
		} else {
			Node left = root2.left;
			root2.left = null;
			root1.right = helper(root1.right, root2);
			helper(root1, left);
		}
		return root1;

	}

	private static void inorder(Node root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	public static void merge(Node root1, Node root2) {
		helper(root1, root2);
		inorder(root1);
	}

	// method_02.=============================================================================

	public class details {
		Node head = null;
		Node prev = null;
	}

	public Node merge_02(Node root1, Node root2) {
		if (root1 == null)
			return root2;
		if (root2 == null)
			return root1;

		details info1 = new details();
		convertDll(root1, info1);

		details info2 = new details();
		convertDll(root2, info2);

		Node head = mergeTwoDLL(info1.head, info2.head);
		return convertToTree(head);

	}

	public Node convertToTree(Node node) {
		if (node.right == null)
			return node;
		
		Node head1 = node;
		Node middle = getMiddle(node);
		Node head2 = middle.right;
		middle.right = null;

		return mergeTwoDLL(convertToTree(head1), convertToTree(head2));

	}

	public Node getMiddle(Node node) {
		Node slow = node;
		Node fast = node;

		while (fast != null && fast.right != null && fast.right.right!=null) {
			slow = slow.right;
			fast = fast.right.right;
		}

		return slow;
	}

	public void convertDll(Node node, details info) {
		if (node == null)
			return;

		convertDll(node.left, info);
		if (info.head == null) {
			info.head = node;
		} else {
			node.left = info.prev;
			info.prev = node.right;
		}

		info.prev = node;
		convertDll(node.right, info);
	}

	public Node mergeTwoDLL(Node node1, Node node2) {

		Node head = new Node(-1);
		Node curr = head;
		while (node1 != null || node2 != null) {

			if (node1 != null && node2 != null) {
				if (node1.data < node2.data) {
					curr.right = node1;
					node1 = node1.right;
				} else {
					curr.right = node1;
					node2 = node2.right;
				}
				curr = curr.right;

			} else {
				if (node1 != null) {
					curr.right = node1;
					node1 = node1.right;
				} else if (node2 != null) {
					curr.right = node2;
					node2 = node2.right;
				}
				curr = curr.right;
			}
		}
		return head.right;

	}

}
