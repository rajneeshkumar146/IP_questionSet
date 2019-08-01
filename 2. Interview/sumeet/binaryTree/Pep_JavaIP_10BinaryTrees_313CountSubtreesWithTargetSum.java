package interview.binaryTree;

import java.util.Scanner;

public class Pep_JavaIP_10BinaryTrees_313CountSubtreesWithTargetSum {
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
		
		int tar = scn.nextInt();
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
		solve(nodes[0], tar);
		System.out.println(count);
	}
	
	static int count = 0; // static count is important or you won't know whetehr to return sum or count
	private static int solve(Node node, int tar){
		if(node == null){
			return 0;
		}
		
		int lsum = solve(node.left, tar);
		int rsum = solve(node.right, tar);
		int sum = lsum + rsum + node.data; // calculating sum
		
		if(sum == tar){ // found a valid subtree
			count++;
		}
		
		return sum;
	}
	
	private static class Pair {
		int sum;
		int count;
	}
	
	// return two things at a time
	public static Pair solve2(Node node, int tar){
		if(node == null){
			Pair bp = new Pair();
			bp.sum = 0;
			bp.count = 0;
			return bp;
		}
		
		Pair lp = solve2(node.left, tar);
		Pair rp = solve2(node.right, tar);
		Pair mp = new Pair();
		
		mp.sum = lp.sum + rp.sum + node.data;
		mp.count = lp.count + rp.count + (mp.sum == tar? 1: 0);
		
		return mp;
	}

}
