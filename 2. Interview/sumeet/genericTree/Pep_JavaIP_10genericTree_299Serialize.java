package interview.genericTree;

import java.util.ArrayList;
import java.util.Scanner;

public class Pep_JavaIP_10genericTree_299Serialize {
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
//		display(root);
		StringBuilder sb = new StringBuilder();
		serialize(root, sb);
		System.out.println(sb);
	}
	
	private static void serialize(Node node, StringBuilder sb){
		sb.append(node.data);
		sb.append("_");
		
		for(Node child: node.children){
			serialize(child, sb);
		}
		
		sb.append("#");
	}

}

/*
21
10 20 50 -1 60 -1 70 -1 -1 30 80 -1 90 -1 -1 40 60 -1 70 -1 -1
10_20_50_#60_#70_##30_80_#90_##40_60_#70_###
*/

//test case 2
/*
10
10 20 30 40 -1 50 -1 -1 -1 -1
10_20_30_40_#50_####
*/