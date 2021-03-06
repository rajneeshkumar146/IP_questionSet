package interview.binaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_10BinaryTrees_358WidthOfTree {
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
		traverse(root, 0);
		System.out.println(max - min);
	}
	
	static int min;
	static int max;
	
	private static void traverse(Node node, int dist){
		if(node == null){
			return;
		}
		
		min = Math.min(min, dist);
		max = Math.max(max, dist);
		
		traverse(node.left, dist - 1);
		traverse(node.right, dist + 1);
	}

}

// https://www.geeksforgeeks.org/width-binary-tree-set-1/
/*Test Case 1
12
1 2 3 -1 4 5 -1 -1 -1 6 7 8
2
*/

/*Test Case 2
7
1 2 3 4 5 6 7
4
*/