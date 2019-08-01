package interview.binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Pep_JavaIP_10BinaryTrees_319PrintVertically {
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

	private static void solve(Node node) {
		HashMap<Integer, ArrayList<Node>> map = new HashMap<>();
		traverse(node, 0, map);

		ArrayList<Integer> keys = new ArrayList<>(map.keySet());
		Collections.sort(keys);

		for (int key : keys) {
			for (Node temp : map.get(key)) {
				System.out.print(temp.data + " ");
			}
			System.out.println();
		}
	}

	// vertical changees whether you go left or right.
	private static void traverse(Node node, int dist, HashMap<Integer, ArrayList<Node>> map) {
		if (node == null) {
			return;
		}

		if (!map.containsKey(dist)) {
			map.put(dist, new ArrayList<>());
		}
		map.get(dist).add(node);

		traverse(node.left, dist - 1, map);
		traverse(node.right, dist + 1, map);
	}
}
