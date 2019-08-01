package interview.binaryTree;

import java.util.Scanner;

public class Pep_JavaIP_10BinaryTrees_327CreateDoublyLinkedListInPlace {
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

		Pair pair = createDLL(root);
		displayDLL(pair);
	}

	// method to display the linked list
	private static void displayDLL(Pair pair) {
		Node temp;
		for (temp = pair.head; temp != null; temp = temp.right) {
			System.out.print(temp.data + " -> ");
		}
		System.out.println(".");

		for (temp = pair.tail; temp != null; temp = temp.left) {
			System.out.print(temp.data + " -> ");
		}
		System.out.println(".");
	}

	private static class Pair {
		Node head;
		Node tail;
		
		Pair(Node head, Node tail){
			this.head = head;
			this.tail = tail;
		}
	}
	
	// method to create a doubly linked list
	private static Pair createDLL(Node treeNode) {
		if(treeNode == null){
			return null;
		}
		
		Pair lp = createDLL(treeNode.left);
		Pair rp = createDLL(treeNode.right);
		
		Pair mp = new Pair(treeNode, treeNode);
		if(lp != null){
			lp.tail.right = mp.head;
			mp.head.left = lp.tail;
			
			mp.head = lp.head;
		}
		
		if(rp != null){
			mp.tail.right = rp.head;
			rp.head.left = mp.tail;
			
			mp.tail = rp.tail;
		}
		
		return mp;
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
2 -> 6 -> 4 -> 7 -> 1 -> 8 -> 5 -> 3 -> .
3 -> 5 -> 8 -> 1 -> 7 -> 4 -> 6 -> 2 -> .
*/