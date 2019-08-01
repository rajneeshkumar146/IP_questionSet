package interview.binaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_10BST_389MedianO1Space {
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
		int median = solve(root, size);
		System.out.println(median);
	}
	
	// using morris traversal
	private static int solve(Node root, int size){
		int sum = 0;
		Node node = root;
		
		int count = 0;
		int n1 = (size + 1) / 2;
		int n2 = (size + 2) / 2;
		
		while(node != null){
			if(node.left != null){
				Node lkarm = leftsRightmost(node);
				
				if(lkarm.right == null){
					lkarm.right = node;
					node = node.left;
				} else {
					count++;
					if(count == n1 || count == n2){
						sum += node.data;
					}
					
					lkarm.right = null;
					node = node.right;
				}
			} else {
				count++;
				if(count == n1 || count == n2){
					sum += node.data;
				}
				
				node = node.right;
			}
		}
		
		return size % 2 == 0? sum / 2: sum;
	}
	
	private static Node leftsRightmost(Node node){
		Node curr = node.left;
		
		while(curr.right != null && curr.right != node){
			curr = curr.right;
		}
		
		return curr;
	}
}

// https://www.geeksforgeeks.org/find-median-bst-time-o1-space/
/*Test Case 1
7
50 25 75 12 37 62 87
50
*/

/*Test Case 2
11
50 20 70 10 30 60 80 -1 -1 25 35
35
*/

/*Test Case 3
12
50 20 70 10 30 60 80 -1 -1 25 36 55
43
*/