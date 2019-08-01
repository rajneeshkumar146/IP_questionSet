package interview.binaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_10BST_387LargestBST {
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
		Pair p = isBST(root);
		System.out.println(p.largestBST.data + " " + p.largestBSTSize);
	}
	
	private static class Pair {
		boolean isBST = true;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		Node largestBST;
		int largestBSTSize;
	}
	
	private static Pair isBST(Node node){
		if(node == null){
			return new Pair();
		}
		
		Pair lp = isBST(node.left);
		Pair rp = isBST(node.right);
		
		Pair mp = new Pair();
		mp.min = Math.min(node.data, Math.min(lp.min, rp.min));
		mp.max = Math.max(node.data, Math.max(lp.max, rp.max));
		mp.isBST = lp.isBST && rp.isBST && node.data > lp.max && node.data < rp.min;
		
		if(mp.isBST){
			mp.largestBST = node;
			mp.largestBSTSize = lp.largestBSTSize + rp.largestBSTSize + 1;
		} else {
			mp.largestBST = lp.largestBSTSize > rp.largestBSTSize? lp.largestBST: rp.largestBST;
			mp.largestBSTSize = lp.largestBSTSize > rp.largestBSTSize? lp.largestBSTSize: rp.largestBSTSize;
		}
		
		return mp;
	}
	
}

// https://www.geeksforgeeks.org/largest-bst-binary-tree-set-2/
/*Test Case 1
11
50 25 75 12 37 62 87 -1 -1 30 51
25 5
*/

/*Test Case 2
12
50 25 75 12 37 62 87 -1 -1 -1 -1 49
75 4
*/
