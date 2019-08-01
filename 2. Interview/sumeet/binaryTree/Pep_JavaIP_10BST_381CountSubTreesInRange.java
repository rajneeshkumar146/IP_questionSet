package interview.binaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_10BST_381CountSubTreesInRange {
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

		int lo = scn.nextInt();
		int hi = scn.nextInt();
		
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
		Pair p = solve(root, lo, hi);
		System.out.println(p.countSubTreesInRange);
	}
	
	private static class Pair {
		boolean inRange = true;
		int countSubTreesInRange;
	}
	
	private static Pair solve(Node node, int lo, int hi){
		if(node == null){
			return new Pair();
		}
		
		Pair lp = solve(node.left, lo, hi);
		Pair rp = solve(node.right, lo, hi);
		
		Pair mp = new Pair();
		
		mp.inRange = lp.inRange && rp.inRange && (node.data >= lo && node.data <= hi);
		mp.countSubTreesInRange = lp.countSubTreesInRange + rp.countSubTreesInRange + (mp.inRange? 1: 0);
		
		return mp;
	}
}

// https://www.geeksforgeeks.org/find-median-bst-time-o1-space/
/*Test Case 1
1 45
7
10 5 50 1 -1 40 100
3
*/

/*Test Case 2
5 45
7
10 5 50 1 -1 40 100
1
*/

/*Test Case 3
2 38
11
50 20 70 10 30 60 80 -1 -1 25 35
1
*/