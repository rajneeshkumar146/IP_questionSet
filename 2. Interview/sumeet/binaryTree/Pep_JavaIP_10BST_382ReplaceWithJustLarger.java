package interview.binaryTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_10BST_382ReplaceWithJustLarger {
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
		Scanner scn = new Scanner(System.in);

		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		
		solve(arr);
		displayArr(arr);
	}
	
	private static void displayArr(int[] arr){
		for(int val: arr){
			System.out.print(val + " ");
		}
		System.out.println(".");
	}
	
	static Node succ = null;
	private static void solve(int[] arr){
		Node root = new Node(arr[arr.length - 1], null, null);
		arr[arr.length - 1] = -1;
		
		for(int i = arr.length - 2; i >= 0; i--){
			succ = null;
			root = add(root, arr[i]);
			arr[i] = succ == null? -1: succ.data;
		}
	}
	
	private static Node add(Node node, int data){
		if(node == null){
			return new Node(data, null, null);
		}
		
		if(data > node.data){
			node.right = add(node.right, data);
		} else if(data < node.data){
			succ = node;
			node.left = add(node.left, data);
		}
		
		return node;
	}
	
}

// https://www.geeksforgeeks.org/replace-every-element-with-the-least-greater-element-on-its-right/
/*Test Case 1
15 
8 58 71 18 31 32 63 92 43 3 91 93 25 80 28
18 63 80 25 32 43 80 93 80 25 93 -1 28 -1 -1 .
*/

/*Test Case 2
7
1 2 3 4 5 6 7
2 3 4 5 6 7 -1 .
*/

/*Test Case 3
7
7 6 5 4 3 2 1
-1 -1 -1 -1 -1 -1 -1 .
*/