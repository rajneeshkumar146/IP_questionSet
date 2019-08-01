package interview.binaryTree;

import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_10BinaryTrees_317IterativePostorder {
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

		solve(nodes[0]);
	}

	private static void solve(Node root){
		// a process stack and results stack
		LinkedList<Node> processStack = new LinkedList<>();
		LinkedList<Integer> resultStack = new LinkedList<>();
		
		processStack.addFirst(root);
		while(processStack.size() > 0){
			// remove from process stack and add to result stack
			Node temp = processStack.removeFirst();
			resultStack.addFirst(temp.data);
			
			// add the children to process stack
			if(temp.left != null){
				processStack.addFirst(temp.left);
			}
			
			if(temp.right != null){
				processStack.addFirst(temp.right);
			}
		}
		
		while(resultStack.size() > 0){
			System.out.print(resultStack.removeFirst() + " ");
		}
	}

}

//test case 1
/*
15 
1 2 3 4 5 6 7 -1 -1 8 9 -1 -1 -1 -1
1 2 4 5 8 9 3 6 7 
*/

//test case 2
/*
7
1 2 3 4 -1 5 -1
1 2 4 3 5 
*/
