package interview.genericTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_10genericTree_307ConstructPerfectKAryTree {
	private static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();

		public Node(int data) {
			this.data = data;
		}
	}

	private static void display(Node node) {
		String str = node.data + " => ";
		for (Node child : node.children) {
			str += child.data + ", ";
		}
		str += ".";
		System.out.println(str);

		for (Node child : node.children) {
			display(child);
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int[] data = new int[scn.nextInt()];
		for (int i = 0; i < data.length; i++) {
			// data[i] = scn.nextInt();
			data[i] = i + 1;
		}
		int k = scn.nextInt();

		Node root = construct(data, k);
		display(root);
	}

	static int idx = 0;

	private static Node construct(int[] data, int k) {
		int h = height(data, k);
		Node root = constructHelper(data, h, k, 0);
		return root;
	}

	private static Node constructHelper(int[] data, int h, int k, int oldPending) {
		Node node = new Node(data[idx]);
		idx++;

		for (int i = 0; i < k; i++) {
			if (idx == data.length) {
				break;
			}

			int currentPending = k - i - 1;
			int pending = currentPending + oldPending;
			
			if (h > 0 && idx < data.length - pending) {
				Node child = constructHelper(data, h - 1, k, pending);
				node.children.add(child);
			} else {
				break;
			}
		}

		return node;
	}

	private static int height(int[] data, int k) {
		int h = 0;
		int count = 1;

		while (count < data.length) {
			h++;
			count += Math.pow(k, h);
		}

		return h;
	}

}
