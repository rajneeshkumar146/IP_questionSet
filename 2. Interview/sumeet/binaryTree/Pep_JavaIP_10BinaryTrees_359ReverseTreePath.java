package interview.binaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_10BinaryTrees_359ReverseTreePath {
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

		int tar = scn.nextInt();
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
		
		reversePathTillTarget(root, tar, new LinkedList<>());
		display(root);
	}
	
	private static boolean reversePathTillTarget(Node node, int tar, LinkedList<Integer> path){
		if(node == null){
			return false;
		}

		path.addLast(node.data);
		if(node.data == tar){
			node.data = path.removeFirst();
			return true;
		}
		
		boolean filc = reversePathTillTarget(node.left, tar, path);
		if(filc){
			node.data = path.removeFirst();
			return true;
		}
		
		boolean firc = reversePathTillTarget(node.right, tar, path);
		if(firc){
			node.data = path.removeFirst();
			return true;
		}
		
		path.removeLast();
		return false;
	}

}

// https://www.geeksforgeeks.org/reverse-tree-path/
/*Test Case 1
8
12
1 2 3 -1 4 5 -1 -1 -1 6 7 8
2 => 8 <= 5
. => 2 <= 4
6 => 4 <= 7
. => 6 <= .
. => 7 <= .
3 => 5 <= .
1 => 3 <= .
. => 1 <= .
*/

/*Test Case 2
6
12
1 2 3 -1 4 5 -1 -1 -1 6 7 8
4 => 6 <= 3
. => 4 <= 2
1 => 2 <= 7
. => 1 <= .
. => 7 <= .
5 => 3 <= .
8 => 5 <= .
. => 8 <= .
*/