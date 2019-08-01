package interview.binaryTree;

import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_10BinaryTrees_335RootToLeafPathWithSum {
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
		str += " <= " + node.data + " => ";
		str += node.right == null ? "." : node.right.data;

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
		int tar = scn.nextInt();
//		display(root);

		rootToLeafPath(root, "", 0, tar);
	}

	private static void rootToLeafPath(Node node, String psf, int ssf, int tar){
		if(node == null){
			return;
		}
		
		psf = psf + node.data + " ";
		ssf = ssf + node.data;
		
		if(node.left == null && node.right == null){
			// its a leaf and the ssf beats old maxsum
			if(ssf == tar){
				System.out.println(psf);
			}
		}
		
		// deeper path, higher sum while we go one level low
		rootToLeafPath(node.left, psf, ssf, tar);
		rootToLeafPath(node.right, psf, ssf, tar);
	}

}
/* Test case 1 
15
1 2 3 4 5 6 7 15 14 13 12 11 10 9 8
20
1 2 5 12 
1 3 6 10 
1 3 7 9
*/

/* Test case 2 
12
1 3 2 7 6 5 4 8 9 10 11 12
20
1 3 7 9 
1 3 6 10 
1 2 5 12 
*/

/* Test case 3 
15
1 2 3 -1 4 5 -1 -1 -1 9 8 7 6 -1 -1
16
1 2 4 9 
1 3 5 7 
*/
