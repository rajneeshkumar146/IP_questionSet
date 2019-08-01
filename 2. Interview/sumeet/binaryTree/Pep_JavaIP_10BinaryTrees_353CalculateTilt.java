package interview.binaryTree;

import java.util.Scanner;

public class Pep_JavaIP_10BinaryTrees_353CalculateTilt {
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
		
//		 display(nodes[0]);
		Pair pair = solve2(nodes[0]);
		System.out.println(pair.tilt);
	}
	
	private static class Pair {
		int sum;
		int tilt;
	}
	
	// return two things at a time
	public static Pair solve2(Node node){
		if(node == null){
			Pair bp = new Pair();
			bp.sum = 0;
			bp.tilt = 0;
			return bp;
		}
		
		Pair lp = solve2(node.left);
		Pair rp = solve2(node.right);
		Pair mp = new Pair();
		
		mp.sum = lp.sum + rp.sum + node.data;
		mp.tilt = lp.tilt + rp.tilt + Math.abs(lp.sum - rp.sum);
		
		return mp;
	}

}


/* Test case 1 
7
4 2 9 3 5 -1 7
15
*/

/* Test case 2 
12 
1 2 3 -1 4 5 -1 -1 -1 6 7 8
42
*/

/* Test case 3 
3
1 2 3
1
*/