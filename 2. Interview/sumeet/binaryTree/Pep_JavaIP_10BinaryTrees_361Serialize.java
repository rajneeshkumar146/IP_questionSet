package interview.binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_10BinaryTrees_361Serialize {
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
		ArrayList<Integer> storage = new ArrayList<>();
		serialize(root, storage);
		System.out.println(storage);
	}

	private static void serialize(Node node, ArrayList<Integer> storage) {
		storage.add(node.data);

		if (node.left != null) {
			serialize(node.left, storage);
		} else {
			storage.add(-1);
		}

		if (node.right != null) {
			serialize(node.right, storage);
		} else {
			storage.add(-1);
		}
	}

}

// https://www.geeksforgeeks.org/serialize-deserialize-binary-tree/
/*Test Case 1
12
1 2 3 -1 4 5 -1 -1 -1 6 7 8
[1, 2, -1, 4, 6, -1, -1, 7, -1, -1, 3, 5, 8, -1, -1, -1, -1]
*/

/*Test Case 2
7 
1 2 3 4 5 6 7
[1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1]
*/
