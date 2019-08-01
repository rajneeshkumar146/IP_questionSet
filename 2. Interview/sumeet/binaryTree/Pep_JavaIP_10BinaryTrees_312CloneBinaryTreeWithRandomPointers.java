package interview.binaryTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_10BinaryTrees_312CloneBinaryTreeWithRandomPointers {
	private static class Node {
		int data;
		Node left;
		Node right;
		Node random;

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
		str += " => " + node.data + "[R:" + node.random.data + "] <= ";
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

		int size = 0;
		HashMap<Integer, Node> randomMap = new HashMap<>();

		Node[] nodes = new Node[arr.length];
		for (int i = 0; i < nodes.length; i++) {
			if (arr[i] != -1) {
				size++;
				nodes[i] = new Node(arr[i], null, null);

				if (i > 0) {
					int pi = (i - 1) / 2;

					if (i == 2 * pi + 1) {
						nodes[pi].left = nodes[i];
					} else {
						nodes[pi].right = nodes[i];
					}
				}

				randomMap.put(nodes[i].data, nodes[i]);
			}
		}

		for (int i = 0; i < size; i++) {
			int from = scn.nextInt();
			int to = scn.nextInt();
			randomMap.get(from).random = randomMap.get(to);
		}

//		display(nodes[0]);
		Node cloneRoot = clone(nodes[0]);
		display(cloneRoot);
	}

	private static Node clone(Node node) {
		// created copies of nodes between themselves and their left children
		createCloneNodesInTheTree(node);
		// using the structure, traversed and set randoms for clones
		setRandomsInClone(node);
		// cleaned the tree back, removed and collected cloned nodes.
		return clearOriginalTree(node);
	}

	private static Node createCloneNodesInTheTree(Node onode) {
		if (onode == null) {
			return null;
		}

		Node clnode = createCloneNodesInTheTree(onode.left);
		Node crnode = createCloneNodesInTheTree(onode.right);

		Node cnode = new Node(onode.data, clnode, null);
		onode.left = cnode;

		return onode;
	}

	private static void setRandomsInClone(Node onode) {
		// work
		if (onode.left != null) {
			onode.left.random = onode.random.left;
		}

		// left
		if (onode.left != null && onode.left.left != null) {
			setRandomsInClone(onode.left.left);
		}
		// right
		if (onode.right != null) {
			setRandomsInClone(onode.right);
		}
	}

	private static Node clearOriginalTree(Node onode) {
		// work
		Node cnode = onode.left;
		Node lcnode = null;
		Node rcnode = null;
		
		// left
		if (onode.left != null && onode.left.left != null) {
			lcnode = clearOriginalTree(onode.left.left);
		}

		// right
		if (onode.right != null) {
			rcnode = clearOriginalTree(onode.right);
		}
		
		// work
		if(onode.left != null){
			onode.left = onode.left.left;
			cnode.left = lcnode;
			cnode.right = rcnode;
		} 
		
		return cnode;
	}
}

// test case 1
/*
15 
1 2 3 4 5 6 7 -1 -1 8 9 -1 -1 -1 -1
1 8
2 6
3 9
4 4 
5 9
6 7
7 6
8 4
9 2
2 => 1[R:8] <= 3
4 => 2[R:6] <= 5
. => 4[R:4] <= .
8 => 5[R:9] <= 9
. => 8[R:4] <= .
. => 9[R:2] <= .
6 => 3[R:9] <= 7
. => 6[R:7] <= .
. => 7[R:6] <= .
*/

//test case 2
/*
7
1 2 3 4 -1 5 -1
1 5
2 5
3 4
4 2
5 1
2 => 1[R:5] <= 3
4 => 2[R:5] <= .
. => 4[R:2] <= .
5 => 3[R:4] <= .
. => 5[R:1] <= .
*/