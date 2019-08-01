package interview.binaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_10BST_385MaximumElement {
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
		str += " => " + node.data + " <= ";
		str += node.right == null ? "." : node.right.data;

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public static void main(String[] args) {
		Node root = null;

		Scanner scn = new Scanner(System.in);

		int d1 = scn.nextInt();
		int d2 = scn.nextInt();
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		Node[] nodes = new Node[arr.length];
		int size = 0;
		for (int i = 0; i < nodes.length; i++) {
			if (arr[i] != -1) {
				nodes[i] = new Node(arr[i], null, null);
				size++;

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

		root = nodes[0];
		Node lca = lca(root, d1, d2);
		maxOnPath(lca, Math.max(d1, d2));
		System.out.println(max.data);
	}
	
	private static Node lca(Node node, int d1, int d2){
		if(node.data < d1 && node.data < d2){
			return lca(node.right, d1, d2);
		} else if(node.data > d1 && node.data > d2){
			return lca(node.left, d1, d2);
		} else {
			return node;
		}
	}
	
	static Node max = null;
	private static void maxOnPath(Node node, int data){
		max = max == null? node: node.data > max.data? node: max;
		
		if(data > node.data){
			maxOnPath(node.right, data);
		} else if(data < node.data){
			maxOnPath(node.left, data);
		}
	}
	
}

// https://www.geeksforgeeks.org/maximum-element-two-nodes-bst/
/*Test Case 1
12 62
7
50 25 75 12 37 62 87
75
*/

/*Test Case 2
20 35
11
50 20 70 10 30 60 80 -1 -1 25 35
35
*/

/*Test Case 3
10 25
11
50 20 70 10 30 60 80 -1 -1 25 35
30
*/