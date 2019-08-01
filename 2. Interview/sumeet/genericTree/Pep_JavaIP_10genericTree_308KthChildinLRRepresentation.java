package interview.genericTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_10genericTree_308KthChildinLRRepresentation {
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
		LRNode lrroot = construct(root);
	
		int value = scn.nextInt();
		int k = scn.nextInt();
		
		solve(lrroot, value, k);
	}

	private static class LRNode {
		int data;
		LRNode firstChild;
		LRNode elderSibling;
	}

	private static void solve(LRNode lrnode, int value, int k) {
		if(lrnode.data == value){
			LRNode child = lrnode.firstChild;
			while(--k > 0){
				child = child.elderSibling;
			}
			System.out.println(child.data);
		}
		
		if (lrnode.firstChild != null) {
			solve(lrnode.firstChild, value, k);
		}

		if (lrnode.elderSibling != null) {
			solve(lrnode.elderSibling, value, k);
		}
	}

	private static LRNode construct(Node node) {
		LRNode lrnode = new LRNode();
		lrnode.data = node.data;

		LRNode prev = lrnode;
		boolean ifc = true;
		for (Node child : node.children) {
			LRNode lrchild = construct(child);

			if (ifc) {
				prev.firstChild = lrchild;
				ifc = false;
			} else {
				prev.elderSibling = lrchild;
			}

			prev = lrchild;
		}

		return lrnode;
	}
}


/*
21
10 20 51 -1 60 -1 70 -1 -1 30 80 -1 90 -1 -1 40 60 -1 70 -1 -1
30 2
90
*/

//test case 2
/*
24
10 20 30 40 -1 50 -1 -1 -1 60 80 90 -1 100 -1 -1 70 -1 50 -1 40 -1 -1 -1
60 3
50
*/
