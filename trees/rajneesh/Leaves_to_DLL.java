package Tree;

public class Leaves_to_DLL {

	class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	class Res {
		Node head = null;
		Node prev = null;
	}

	Node convertToDLL(Node root) {
		// your code here
		Res res = new Res();
		DLLleaves(root, res);
		printDLL(res.head);
		return res.head;
	}

	void DLLleaves(Node root, Res res) {
		if (root == null)
			return;
		DLLleaves(root.left, res);
		if (root.left == null && root.right == null) {
			if (res.prev == null)
				res.head = root;
			else {
				res.prev.right = root;
				root.left = res.prev;
			}
			res.prev = root;
		}
		DLLleaves(root.right, res);
	}

	void printDLL(Node head) {
		Node curr = head;
		Node prev = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			prev = curr;
			curr = curr.right;
		}
		System.out.println();
		curr = prev;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.left;
		}
	}

	void pritntDLL() {
		return;
	}
}