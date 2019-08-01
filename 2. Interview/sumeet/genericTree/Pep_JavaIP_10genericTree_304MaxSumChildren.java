package interview.genericTree;

import java.util.ArrayList;
import java.util.Scanner;

public class Pep_JavaIP_10genericTree_304MaxSumChildren {
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
		
		Pair pair = maxSumChildren(root);
		System.out.println(pair.maxSumNode.data + " " + pair.sum);
	}
	
	private static class Pair {
		Node maxSumNode = null;
		int sum = 0;
	}
	
	private static Pair maxSumChildren(Node node){
		Pair mp = new Pair();
		mp.maxSumNode = node;

		mp.sum = node.data;
		for(Node child: node.children){
			mp.sum += child.data;
		}
		
		for(Node child: node.children){
			Pair cp = maxSumChildren(child);
			if(cp.sum > mp.sum){
				mp = cp;
			}
		}
		
		return mp;
	}
}

/*
21
10 20 51 -1 60 -1 70 -1 -1 30 80 -1 90 -1 -1 40 60 -1 70 -1 -1
20 201
*/

//test case 2
/*
24
10 20 30 40 -1 50 -1 -1 -1 60 80 90 -1 100 -1 -1 70 -1 50 -1 40 -1 -1 -1
60 300
*/
