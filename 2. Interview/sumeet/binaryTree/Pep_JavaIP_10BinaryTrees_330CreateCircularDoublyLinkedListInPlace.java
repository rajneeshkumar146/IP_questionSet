package interview.binaryTree;

import java.util.Scanner;

public class Pep_JavaIP_10BinaryTrees_330CreateCircularDoublyLinkedListInPlace {
	private static class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public static void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";

		str += node.left == null ? "." : node.left.data;
		str += " <= " + node.data + " => ";
		str += node.right == null ? "." : node.right.data;

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		// creation using the level order, seeing it like a heap
		// -1 says there is no node
		Node[] nodes = new Node[arr.length];
		for (int i = 0; i < nodes.length; i++) {
			if (arr[i] != -1) {
				nodes[i] = new Node(arr[i], null, null);

				if (i > 0) {
					int pi = (i - 1) / 2;

					if (i == 2 * pi + 1) {
						nodes[pi].left = nodes[i];
					} else {
						nodes[pi].right = nodes[i];
					}
				}
			}
		}
		Node root = nodes[0];
//		display(root);

		Node node = createCircularDLL(root);
		displayDLL(node);
	}

	// method to display the linked list
	private static void displayDLL(Node node) {
		Node head = node;
		Node tail = node.left;
		
		Node temp;
		for (temp = head; temp != tail; temp = temp.right) {
			System.out.print(temp.data + " -> ");
		}
		System.out.println(tail.data + ".");

		for (temp = tail; temp != head; temp = temp.left) {
			System.out.print(temp.data + " -> ");
		}
		System.out.println(head.data + ".");
	}

	// method to create a doubly linked list
	private static Node createCircularDLL(Node treeNode) {
		if(treeNode == null){
			return null;
		}
		
		// left side list circularised
		Node lhead = createCircularDLL(treeNode.left);
		// right side list circularised
		Node rhead = createCircularDLL(treeNode.right);

		Node head = treeNode;
		head.left = head;
		head.right = head;
		
		// left and node merged
		if(lhead != null){
			head = lhead;
			
			Node tail = head.left;
			
			tail.right = treeNode;
			treeNode.left = tail;
			
			treeNode.right = head;
			head.left = treeNode;
		}
		
		// merged with right
		if(rhead != null){
			Node tail = head.left;
			Node rtail = rhead.left;
			
			tail.right = rhead;
			rhead.left = tail;
			
			rtail.right = head;
			head.left = rtail;
		}
		
		return head;
	}
}

/* Test case 1 
12 
1 2 3 4 5 6 7 8 9 10 11 12 
8 -> 4 -> 9 -> 2 -> 10 -> 5 -> 11 -> 1 -> 12 -> 6 -> 3 -> 7 -> .
7 -> 3 -> 6 -> 12 -> 1 -> 11 -> 5 -> 10 -> 2 -> 9 -> 4 -> 8 -> .
*/

/* Test case 2 
12 
1 2 3 -1 4 5 -1 -1 -1 6 7 8
2 -> 6 -> 4 -> 7 -> 1 -> 8 -> 5 -> 3.
3 -> 5 -> 8 -> 1 -> 7 -> 4 -> 6 -> 2.
*/