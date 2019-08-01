package Tree;

import java.util.HashMap;

public class Duplicate_Subtree {

	static HashMap<String, Integer> map;

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	String inorderTraversal(Node node) {
		if (node == null)
			return "";

		String str = "(";
		str += inorderTraversal(node.left);
		str += Integer.toString(node.data);
		str += inorderTraversal(node.right);
		str += ")";

		if (map.get(str) != null && map.get(str) == 1)
			System.out.print(node.data + " ");

		if (map.containsKey(str))
			map.put(str, map.get(str) + 1);
		else
			map.put(str, 1);

		return str;
	}

	void printAllDups(Node root) {
		map = new HashMap<>();
		inorderTraversal(root);
	}

}
