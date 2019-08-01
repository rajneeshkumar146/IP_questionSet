package interview.binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_10BinaryTrees_357ConstructExpressionTree {
	private static class Node {
		char data;
		Node left;
		Node right;

		Node(char data, Node left, Node right) {
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
		String postfix = scn.nextLine();

		Node root = construct(postfix);
		display(root);
	}

	private static Node construct(String postfix){
		LinkedList<Node> stack = new LinkedList<>();
		for(int i = 0; i < postfix.length(); i++){
			char ch = postfix.charAt(i);
			
			if(Character.isAlphabetic(ch)){
				stack.addFirst(new Node(ch, null, null));
			} else {
				Node n1 = stack.removeFirst();
				Node n2 = stack.removeFirst();
				stack.addFirst(new Node(ch, n2, n1));
			}
		}
		
		return stack.removeFirst();
	}
}

////https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
/*Test Case 1
abc*d*-
a => - <= *
. => a <= .
* => * <= d
b => * <= c
. => b <= .
. => c <= .
. => d <= .
*/

/*Test Case 2
ab+cd-*
+ => * <= -
a => + <= b
. => a <= .
. => b <= .
c => - <= d
. => c <= .
. => d <= .
*/

/*Test Case 3
12
1 12 3 -1 4 5 -1 -1 -1 -6 -7 -8
11
*/
/*Test Case 1
12
1 2 3 -1 4 5 -1 -1 -1 6 7 8
30
*/

/*Test Case 2
12
1 -12 2 -1 4 5 -1 -1 -1 6 7 8
17
*/

/*Test Case 3
12
1 12 3 -1 4 5 -1 -1 -1 -6 -7 -8
11
*/
