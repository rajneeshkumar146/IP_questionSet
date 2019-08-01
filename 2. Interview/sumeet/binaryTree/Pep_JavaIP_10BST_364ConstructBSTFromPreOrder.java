package interview.binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_10BST_364ConstructBSTFromPreOrder {
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
		int[] pre = new int[Integer.parseInt(scn.next())];
		for (int i = 0; i < pre.length; i++) {
			pre[i] = Integer.parseInt(scn.next());
		}
		
		Node root = construct(pre, Integer.MIN_VALUE, Integer.MAX_VALUE);
		display(root);
	}
	
	static int idx = 0;
	private static Node construct(int[] pre, int min, int max){
		if(idx == pre.length){
			return null;
		} 
		
		if(pre[idx] < min || pre[idx] > max){
			return null;
		} else {
			Node node = new Node(pre[idx], null, null);
			idx++;
			
			node.left = construct(pre, min, node.data);
			node.right = construct(pre, node.data, max);
			
			return node;
		}
	}
}

//https://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversa/
/*Test Case 1
6
10 5 1 7 40 50
5 => 10 <= 40
1 => 5 <= 7
. => 1 <= .
. => 7 <= .
. => 40 <= 50
. => 50 <= .
*/

/*Test Case 2
9
50 20 10 30 25 35 70 60 80
20 => 50 <= 70
10 => 20 <= 30
. => 10 <= .
25 => 30 <= 35
. => 25 <= .
. => 35 <= .
60 => 70 <= 80
. => 60 <= .
. => 80 <= .
*/