package interview.binaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_10BST_377AddGreater {
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
		
		addGreater(root);
		display(root);
	}
	
	static int sum = 0;
	private static void addGreater(Node node){
		if(node == null){
			return;
		}

		addGreater(node.right);
		
		int odata = node.data;
		node.data += sum;
		sum += odata;
		
		addGreater(node.left);
	}

}

// https://www.geeksforgeeks.org/add-greater-values-every-node-given-bst/
/*Test Case 1
7
50 25 75 12 37 62 87
336 => 274 <= 162
348 => 336 <= 311
. => 348 <= .
. => 311 <= .
224 => 162 <= 87
. => 224 <= .
. => 87 <= .
*/

/*Test Case 2
11
50 20 70 10 30 60 80 -1 -1 25 35
370 => 260 <= 150
380 => 370 <= 325
. => 380 <= .
350 => 325 <= 295
. => 350 <= .
. => 295 <= .
210 => 150 <= 80
. => 210 <= .
. => 80 <= .
*/