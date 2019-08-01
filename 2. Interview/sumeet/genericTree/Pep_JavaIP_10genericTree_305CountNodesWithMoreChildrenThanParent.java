package interview.genericTree;

import java.util.ArrayList;
import java.util.Scanner;

public class Pep_JavaIP_10genericTree_305CountNodesWithMoreChildrenThanParent {
	private static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();

		public Node(int data) {
			this.data = data;
		}
	}

	private static void display(Node node) {
		String str = node.data + " => ";
		for (Node child : node.children) {
			str += child.data + ", ";
		}
		str += ".";
		System.out.println(str);

		for (Node child : node.children) {
			display(child);
		}
	}

	static int idx = 0;

	private static Node construct(int[] data) {
		if (idx == data.length) {
			return null;
		} else if (data[idx] == -1) {
			idx++;
			return null;
		}

		Node node = new Node(data[idx]);
		idx++;

		while (true) {
			Node child = construct(data);
			if (child != null) {
				node.children.add(child);
			} else {
				break;
			}
		}

		return node;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int[] data = new int[scn.nextInt()];
		for (int i = 0; i < data.length; i++) {
			data[i] = scn.nextInt();
		}

		Node root = construct(data);
		// display(root);
		
		solve(root, Integer.MAX_VALUE);
		System.out.println(count);
	}
	
	static int count = 0;
	public static void solve(Node node, int countPChild){
		if(node.children.size() > countPChild){
			count++;
		}
		
		for(Node child: node.children){
			solve(child, node.children.size());
		}
	}

}

/*
21
10 20 51 -1 60 -1 70 -1 -1 30 80 -1 90 -1 -1 40 60 -1 70 -1 -1
0
*/

//test case 2
/*
24
10 20 30 40 -1 50 -1 -1 -1 60 80 90 -1 100 -1 -1 70 -1 50 -1 40 -1 -1 -1
2
*/
