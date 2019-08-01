package interview.genericTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_10genericTree_311Diameter {
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
		DiaPair pair = diameter(root);
		System.out.println(pair.diameter);
	}
	
	private static class DiaPair {
		int height = -1;
		int diameter = 0;
	}
	
	public static DiaPair diameter(Node node){
		DiaPair mp = new DiaPair();
		
		int firstDeepest = -1;
		int secondDeepest = -1;
		boolean ifc = true;
		for(Node child: node.children){
			DiaPair cp = diameter(child);
			if(ifc == true){
				mp.height = cp.height;
				mp.diameter = cp.diameter;
				
				ifc = false;
			} else {
				if(cp.diameter > mp.diameter){
					mp.diameter = cp.diameter;
				}
			}
			
			if(firstDeepest == -1){
				firstDeepest = cp.height;
			} else if(cp.height > firstDeepest){
				secondDeepest = firstDeepest;
				firstDeepest = cp.height;
			} else if(secondDeepest == -1){
				secondDeepest = cp.height;
			} else if(cp.height > secondDeepest) {
				secondDeepest = cp.height;
			}
		}
		
		mp.diameter = Math.max(mp.diameter, firstDeepest + secondDeepest + 2);
		mp.height = firstDeepest + 1;
		
		return mp;
	}
}

/*
21
10 20 51 -1 60 -1 70 -1 -1 30 80 -1 90 -1 -1 40 60 -1 70 -1 -1
4
*/

//test case 2
/*
24
10 20 30 40 -1 50 -1 -1 -1 60 80 90 -1 100 -1 -1 70 -1 50 -1 40 -1 -1 -1
6
*/
