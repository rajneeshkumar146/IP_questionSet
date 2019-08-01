package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Make_Binary_Tree_From_Linked_List {
	class Tree {
		int data;
		Tree left;
		Tree right;

		Tree(int d) {
			data = d;
			left = null;
			right = null;
		}
	}

	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public Tree convert(Node head, Tree node) {
		Queue<Tree> q = new LinkedList<Tree>();

		if (head == null) {
			node = null;
			return null;
		}

		node = new Tree(head.data);
		q.add(node);

		head = head.next;
		while (head != null) {
			Tree parent = q.poll();

			Tree leftChild = null, rightChild = null;
			leftChild = new Tree(head.data);
			q.add(leftChild);
			head = head.next;
			if (head != null) {
				rightChild = new Tree(head.data);
				q.add(rightChild);
				head = head.next;
			}

			parent.left = leftChild;
			parent.right = rightChild;
		}

		return node;
	}
}
