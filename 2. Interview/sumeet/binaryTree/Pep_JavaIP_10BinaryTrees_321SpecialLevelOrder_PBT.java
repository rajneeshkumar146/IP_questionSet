package interview.binaryTree;

import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_10BinaryTrees_321SpecialLevelOrder_PBT {

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

		// display(nodes[0]);
		solve(nodes[0]);
	}

	private static void solve(Node root) {
		System.out.print(root.data + " ");

		// a list for left items and a list for right items
		LinkedList<Node> lq = new LinkedList<>();
		LinkedList<Node> rq = new LinkedList<>();
		lq.addLast(root.left);
		rq.addLast(root.right);

		boolean processLeft = true;
		while (lq.size() > 0 || rq.size() > 0) {
			// remove once from left side and once from right side
			LinkedList<Node> queue = processLeft ? lq : rq;
			Node temp = queue.removeFirst();
			System.out.print(temp.data + " ");
			
			if (processLeft) {
				// add from left side in left list
				if (temp.left != null) {
					queue.addLast(temp.left);
				}

				if (temp.right != null) {
					queue.addLast(temp.right);
				}
			} else {
				// add from right side in right list
				if (temp.right != null) {
					queue.addLast(temp.right);
				}
				
				if (temp.left != null) {
					queue.addLast(temp.left);
				}
			}

			processLeft = !processLeft;
		}
	}

	private static void normalLevelOrder(Node root) {
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(root);

		while (queue.size() > 0) {
			Node temp = queue.removeFirst();
			System.out.println(temp.data);

			if (temp.left != null) {
				queue.addLast(temp.left);
			}

			if (temp.right != null) {
				queue.addLast(temp.right);
			}
		}
	}
}
