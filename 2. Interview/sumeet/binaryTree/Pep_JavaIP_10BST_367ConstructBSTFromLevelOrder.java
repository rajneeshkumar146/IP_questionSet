package interview.binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_10BST_367ConstructBSTFromLevelOrder {
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
		Scanner scn = new Scanner(System.in);
		int[] level = new int[Integer.parseInt(scn.next())];
		for (int i = 0; i < level.length; i++) {
			level[i] = Integer.parseInt(scn.next());
		}

		Node root = construct(level);
		display(root);
	}

	private static class Pair {
		Node parent;
		int min;
		int max;

		Pair(Node node, int min, int max) {
			this.parent = node;
			this.min = min;
			this.max = max;
		}
	}

	private static Node construct(int[] level) {
		Node root = null;

		LinkedList<Pair> queue = new LinkedList<>();
		queue.addLast(new Pair(null, Integer.MIN_VALUE, Integer.MAX_VALUE));

		int idx = 0;
		while (queue.size() > 0 && idx < level.length) {
			Pair rp = queue.removeFirst();

			if (level[idx] >= rp.min && level[idx] <= rp.max) {
				Node node = new Node(level[idx], null, null);
				queue.add(new Pair(node, rp.min, level[idx]));
				queue.add(new Pair(node, level[idx], rp.max));

				if (rp.parent == null) {
					root = node;
				} else {
					if(level[idx] < rp.parent.data){
						rp.parent.left = node;
					} else {
						rp.parent.right = node;
					}
				}
				
				idx++;
			}
		}

		return root;
	}
}

// https://www.geeksforgeeks.org/construct-bst-given-level-order-traversal/
/* Test case 1
9
7 4 12 3 6 8 1 5 10
4 => 7 <= 12
3 => 4 <= 6
1 => 3 <= .
. => 1 <= .
5 => 6 <= .
. => 5 <= .
8 => 12 <= .
. => 8 <= 10
. => 10 <= .
*/

/* Test case 2
8
50 20 70 10 30 60 80 25
20 => 50 <= 70
10 => 20 <= 30
. => 10 <= .
25 => 30 <= .
. => 25 <= .
60 => 70 <= 80
. => 60 <= .
. => 80 <= .
*/
