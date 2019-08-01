package interview.binaryTree;

import java.util.Scanner;

public class Pep_JavaIP_10BinaryTrees_362MaximumPathSumLeaves {
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

		Pair pair = maxPathSum(nodes[0]);
//		System.out.println(mpspath);
		System.out.println(mps);
	}

	private static class Pair {
		int mpsrooted = 0;
		String mpsrootedpath = "";

		Pair(int mpsrooted, String mpsrootedpath) {
			this.mpsrooted = mpsrooted;
			this.mpsrootedpath = mpsrootedpath;
		}
	}

	static int mps = Integer.MIN_VALUE;
	static String mpspath = "";

	private static Pair maxPathSum(Node node) {
		if (node.left == null && node.right == null) {
			return new Pair(node.data, node.data + " ");
		} else if (node.left == null) {
			Pair rp = maxPathSum(node.right);
			return new Pair(rp.mpsrooted + node.data, rp.mpsrootedpath + " " + node.data);
		} else if (node.right == null) {
			Pair lp = maxPathSum(node.left);
			return new Pair(lp.mpsrooted + node.data, lp.mpsrootedpath + " " + node.data);
		} else {
			Pair lp = maxPathSum(node.left);
			Pair rp = maxPathSum(node.right);

			Pair mp = new Pair(0, "");

			// calculating rooted mps - begin
			// comparing lp.mpsrooted + node.data, rp.mpsrooted + node.data
			if (lp.mpsrooted >= rp.mpsrooted) {
				mp.mpsrooted = lp.mpsrooted + node.data;
				mp.mpsrootedpath = lp.mpsrootedpath + " " + node.data;
			} else {
				mp.mpsrooted = rp.mpsrooted + node.data;
				mp.mpsrootedpath = rp.mpsrootedpath + " " + node.data;
			}
			// calculating rooted mps - end

			// calculating mps
			// comparing mp.mpsrooted and lp.mpsrooted + node.data +
			// rp.mpsrooted
			if (lp.mpsrooted + node.data + rp.mpsrooted > mps) {
				mps = lp.mpsrooted + node.data + rp.mpsrooted;
				mpspath = lp.mpsrootedpath + " " + node.data + " " + rp.mpsrootedpath;
			}
			
			return mp;
		}
	}
}

//https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
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