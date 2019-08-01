package interview.binaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_10BST_376ReswapSwappedNodes {
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

		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

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

		root = nodes[0];

		solve(root);
		display(root);
	}

	private static void solve(Node root){
		traverse(root);
		
		int temp = first.data;
		first.data = second.data;
		second.data = temp;
	}
	
	static Node prev = null;
	static Node first = null;
	static Node second = null;
	
	
	private static void traverse(Node node){
		if(node == null){
			return;
		}
		
		traverse(node.left);
		
		if(prev != null && prev.data > node.data){
			if(first == null){
				first = prev;
				second = node;	
			} else {
				second = node;
			}
		}
		prev = node;
		
		traverse(node.right);
	}

}

// https://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/
/*Test Case 1
7
50 62 75 12 37 25 87
25 => 50 <= 75
12 => 25 <= 37
. => 12 <= .
. => 37 <= .
62 => 75 <= 87
. => 62 <= .
. => 87 <= .
*/

/*Test Case 2
11
50 20 70 10 35 60 80 -1 -1 25 30
20 => 50 <= 70
10 => 20 <= 30
. => 10 <= .
25 => 30 <= 35
. => 25 <= .
. => 35 <= .
60 => 70 <= 80
. => 60 <= .
. => 80 <= .
*/