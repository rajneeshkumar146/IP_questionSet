package interview.binaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_10BST_378InorderSuccessor {
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

		int data = scn.nextInt();
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
		inorderSuccessor(root, data);
	}
	
	private static void inorderSuccessor(Node node, int data){
		Node succ = null;
		
		while(node != null){
			if(data > node.data){
				node = node.right;
			} else if(data < node.data){
				succ = node;
				node = node.left;
			} else {
				// leftmost of right child
				if(node.right != null){
					succ = node.right;
					
					while(succ.left != null){
						succ = succ.left;
					}
				}
				
				break;
			}
		}
		
		System.out.println(succ == null? "Not found": succ.data);
	}

}

// https://www.geeksforgeeks.org/inorder-predecessor-successor-given-key-bst/
/*Test Case 1
37
7
50 25 75 12 37 62 87
50
*/

/*Test Case 2
80
11
50 20 70 10 30 60 80 -1 -1 25 35
Not found
*/

/*Test Case 3
50
11
50 20 70 10 30 60 80 -1 -1 25 35
60
*/