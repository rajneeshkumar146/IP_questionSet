package interview.binaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_10BinaryTrees_340MaxWidth {
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
		str += " <= " + node.data + " => ";
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

		// creation using the level order, seeing it like a heap
		// -1 says there is no node
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
		Node root = nodes[0];
//		display(root);

		int width1 = solveLevelWay(root);
		solvePreorderWay(root, 0, new HashMap<>());
		System.out.println(width1 + " " + width);
	}
	
	private static int solveLevelWay(Node root){
		LinkedList<Node> queue = new LinkedList<>();

		int width = 0;
		// level order keeping track of levels
		queue.add(root);
		while(queue.size() > 0){
			// a new level starts, has count elements
			int count = queue.size();
			if(count > width){
				width = count;
			}
			
			// finishing the level
			while(count-- > 0){
				Node rem = queue.removeFirst();

				if(rem.left != null){
					queue.addLast(rem.left);
				}
				
				if(rem.right != null){
					queue.addLast(rem.right);
				}
			}
		}
		
		return width;
	}

	static int width = Integer.MIN_VALUE;
	private static void solvePreorderWay(Node node, int level, HashMap<Integer, Integer> lwmap){
		if(node == null){
			return;
		}

		// each time a level is visited, we add a count to number of elements on that level
		lwmap.put(level, lwmap.containsKey(level)? lwmap.get(level) + 1: 1);
		if(lwmap.get(level) > width){ // each time static width loses, we have a higher width
			width = lwmap.get(level);
		}
		
		solvePreorderWay(node.left, level + 1, lwmap);
		solvePreorderWay(node.right, level + 1, lwmap);
	}

}
/* Test case 1 
12 
1 2 3 4 5 6 7 8 9 10 11 12 
5 5
*/

/* Test case 2 
12 
1 2 3 -1 4 5 -1 -1 -1 6 7 8
3 3
*/

/* Test case 3 
12 
1 2 3 4 -1 -1 5 6 7 -1 -1 -1
2 2
*/