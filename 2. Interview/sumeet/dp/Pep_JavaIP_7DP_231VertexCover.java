package interview.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_7DP_231VertexCover {
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
		System.out.println(solve(nodes[0], new HashMap<>()));
	}

	private static int solve(Node node, HashMap<Node, Integer> qb) {
		if(node == null){
			return 0;
		} else if(node.left == null && node.right == null){
			return 0;
		} else if(qb.containsKey(node)){
			return qb.get(node);
		}
		
		// option 1 - take root
		int f1 = 1 + solve(node.left, qb) + solve(node.right, qb);
		
		// option 2 - don't take root (take root's left and right then)
		int f2 = 0;
		if(node.left != null){
			f2 = 1 + solve(node.left.left, qb) + solve(node.left.right, qb);
		}
		
		if(node.right != null){
			f2 += 1 + solve(node.right.left, qb) + solve(node.right.right, qb);
		}
		
		int f = Math.min(f1, f2);
		qb.put(node, f);
		
		return f;
	}
}

//https://www.geeksforgeeks.org/vertex-cover-problem-set-2-dynamic-programming-solution-tree/
/* Test case 1 
9
20 8 22 4 12 -1 25 10 14
3
*/

/* Test case 2 
7
1 2 3 4 5 6 7
2
*/

/* Test case 3 
15
1 2 3 4 -1 -1 7 8 9 -1 -1 -1 -1 -1 15
3
*/