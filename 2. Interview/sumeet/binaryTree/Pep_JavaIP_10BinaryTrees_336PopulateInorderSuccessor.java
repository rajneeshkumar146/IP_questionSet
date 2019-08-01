package interview.binaryTree;

import java.util.Scanner;

public class Pep_JavaIP_10BinaryTrees_336PopulateInorderSuccessor {
	private static class Node {
		int data;
		Node left;
		Node right;
		Node next;

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
		str += "[" + (node.next != null ? node.next.data : "null") + "]";

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

		setNext(root);
		display(root);
	}

	static Node prev;
	private static void setNext(Node node) {
		if (node == null) {
			return;
		}

		setNext(node.left);

		if (prev != null) {
			prev.next = node;
		}
		prev = node;

		setNext(node.right);
	}
}


/* Test case 1 
12 
1 2 3 4 5 6 7 8 9 10 11 12 
2 <= 1 => 3[12]
4 <= 2 => 5[10]
8 <= 4 => 9[9]
. <= 8 => .[4]
. <= 9 => .[2]
10 <= 5 => 11[11]
. <= 10 => .[5]
. <= 11 => .[1]
6 <= 3 => 7[7]
12 <= 6 => .[3]
. <= 12 => .[6]
. <= 7 => .[null]
*/

/* Test case 2 
12 
1 2 3 -1 4 5 -1 -1 -1 6 7 8
2 <= 1 => 3[8]
. <= 2 => 4[6]
6 <= 4 => 7[7]
. <= 6 => .[4]
. <= 7 => .[1]
5 <= 3 => .[null]
8 <= 5 => .[3]
. <= 8 => .[5]
*/
