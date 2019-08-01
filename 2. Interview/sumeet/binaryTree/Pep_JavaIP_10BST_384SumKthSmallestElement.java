package interview.binaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_10BST_384SumKthSmallestElement {
	private static class Node {
		int data;
		Node left;
		Node right;
		int size;
		int sum;

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

		int k = scn.nextInt();
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
		populateProperties(root);
		solve(root, k);
		System.out.println(sum);
	}

	private static void populateProperties(Node node) {
		if (node == null) {
			return;
		}

		populateProperties(node.left);
		populateProperties(node.right);

		node.size = 1 + getSize(node.left) + getSize(node.right);
		node.sum = node.data + getSum(node.left) + getSum(node.right);
	}

	static int sum = 0;

	// alternatives - inorder (recursive, stacks, morris)
	private static void solve(Node node, int k) {
		if(node == null){
			return;
		}
		
		if(k <= getSize(node.left)){
			solve(node.left, k);
		} else if(k == getSize(node.left) + 1){
			sum += getSum(node.left) + node.data;
		} else {
			sum += getSum(node.left) + node.data;
			solve(node.right, k - getSize(node.left) - 1);
		}
	}
	
	private static int getSize(Node node){
		return node == null? 0: node.size;
	}
	
	private static int getSum(Node node){
		return node == null? 0: node.sum;
	}
}

//https://www.geeksforgeeks.org/sum-k-smallest-elements-bst/
/*Test Case 1
3
7
50 25 75 12 37 62 87
74
*/

/*Test Case 2
2
12
50 20 70 10 30 60 80 -1 -1 25 36 55
30
*/

/*Test Case 3
6
12
50 20 70 10 30 60 80 -1 -1 25 36 55
171
*/