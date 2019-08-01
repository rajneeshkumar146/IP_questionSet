package interview.binaryTree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_10BST_366ConvertBSTToMinHeap {
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
		// display(root);

		root = convertBSTToMinHeap(root);
		display(root);
	}

	private static Node convertBSTToMinHeap(Node node) {
		node = convertBSTToSortedCircularLL(node);
		node = convertSortedCircularLLToMinHeap(node);
		return node;
	}

	private static Node convertBSTToSortedCircularLL(Node node) {
		if (node == null) {
			return null;
		}

		Node lhead = convertBSTToSortedCircularLL(node.left);
		Node rhead = convertBSTToSortedCircularLL(node.right);

		Node head = node;
		head.left = head;
		head.right = head;

		// left and node merged
		if (lhead != null) {
			head = lhead;
			Node tail = head.left;

			tail.right = node;
			node.left = tail;

			node.right = head;
			head.left = node;
		}

		// merged with right
		if (rhead != null) {
			Node tail = head.left;
			Node rtail = rhead.left;

			tail.right = rhead;
			rhead.left = tail;

			rtail.right = head;
			head.left = rtail;
		}

		return head;
	}

	private static Node convertSortedCircularLLToMinHeap(Node head) {
		Node root = head;
		Node itr = head.right;
		
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while (queue.size() > 0) {
			Node temp = queue.removeFirst();
			Node one = null;
			Node two = null;
			
			if(itr != root){
				one = itr;
				queue.addLast(one);
				itr = itr.right;
			}
			
			if(itr != root){
				two = itr;
				queue.addLast(two);
				itr = itr.right;
			}
			
			if(one != null){
				temp.left = one;
				one.left = null;
				one.right = null;
			}
			
			if(two != null){
				temp.right = two;
				two.left = null;
				two.right = null;
			}
		}
		
		return root;
	}

}

//https://www.geeksforgeeks.org/in-place-convert-bst-into-a-min-heap/
/*Test Case 1
7
50 25 75 12 37 62 87
25 <= 12 => 37
50 <= 25 => 62
. <= 50 => .
. <= 62 => .
75 <= 37 => 87
. <= 75 => .
. <= 87 => .
*/

/*Test Case 2
11
50 20 70 10 30 60 80 -1 -1 25 35
20 <= 10 => 25
30 <= 20 => 35
70 <= 30 => 80
. <= 70 => .
. <= 80 => .
. <= 35 => .
50 <= 25 => 60
. <= 50 => .
. <= 60 => .
*/

/*Test Case 3
10
50 20 70 10 30 60 80 -1 -1 25
20 <= 10 => 25
30 <= 20 => 50
80 <= 30 => .
. <= 80 => .
. <= 50 => .
60 <= 25 => 70
. <= 60 => .
. <= 70 => .
*/
