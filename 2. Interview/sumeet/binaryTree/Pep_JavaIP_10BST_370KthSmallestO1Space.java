package interview.binaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_10BST_370KthSmallestO1Space {
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

		int k = scn.nextInt();
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
		int kthSmallest = solve(root, k);
		System.out.println(kthSmallest);
	}
	
	// using morris traversal
	private static int solve(Node root, int k){
		int kthSmallest = 0;
		Node node = root;
		
		int count = 0;
		while(node != null){
			if(node.left != null){
				Node lkarm = leftsRightmost(node);
				
				if(lkarm.right == null){
					lkarm.right = node;
					node = node.left;
				} else {
					count++;
					if(count == k){
						kthSmallest = node.data;
					}
					
					lkarm.right = null;
					node = node.right;
				}
			} else {
				count++;
				if(count == k){
					kthSmallest = node.data;
				}
				
				node = node.right;
			}
		}
		
		return kthSmallest;
	}
	
	private static Node leftsRightmost(Node node){
		Node curr = node.left;
		
		while(curr.right != null && curr.right != node){
			curr = curr.right;
		}
		
		return curr;
	}
}

// https://www.geeksforgeeks.org/kth-smallest-element-in-bst-using-o1-extra-space/
/*Test Case 1
3
7
50 25 75 12 37 62 87
37
*/

/*Test Case 2
2
12
50 20 70 10 30 60 80 -1 -1 25 36 55
20
*/

/*Test Case 3
6
12
50 20 70 10 30 60 80 -1 -1 25 36 55
50
*/