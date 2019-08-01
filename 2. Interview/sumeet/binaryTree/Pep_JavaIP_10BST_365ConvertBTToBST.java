package interview.binaryTree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_10BST_365ConvertBTToBST {
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

		convertToBST(root);
		display(root);
	}

	private static void convertToBST(Node node){
		LinkedList<Integer> list = new LinkedList<>();
		traverseToFillList(node, list);
		Collections.sort(list);
		traverseToFillFromList(node, list);
	}
	
	private static void traverseToFillList(Node node, LinkedList<Integer> list){
		if(node == null){
			return;
		}
		
		traverseToFillList(node.left, list);
		list.addLast(node.data);
		traverseToFillList(node.right, list);
	}
	
	private static void traverseToFillFromList(Node node, LinkedList<Integer> list){
		if(node == null){
			return;
		}
		
		traverseToFillFromList(node.left, list);
		node.data = list.removeFirst();
		traverseToFillFromList(node.right, list);
	}
}

/* Test case 1 
12 
1 2 3 4 5 6 7 8 9 10 11 12 
4 <= 8 => 11
2 <= 4 => 6
1 <= 2 => 3
. <= 1 => .
. <= 3 => .
5 <= 6 => 7
. <= 5 => .
. <= 7 => .
10 <= 11 => 12
9 <= 10 => .
. <= 9 => .
. <= 12 => .
*/

/* Test case 2 
12 
1 2 3 -1 4 5 -1 -1 -1 6 7 8
1 <= 5 => 8
. <= 1 => 3
2 <= 3 => 4
. <= 2 => .
. <= 4 => .
7 <= 8 => .
6 <= 7 => .
. <= 6 => .
*/