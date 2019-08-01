package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Binary_Tree_to_BST {

	public static class Node {
		int data;
		Node left;
		Node right;

		Node(int x) {
			data = x;
		}
	}

	// method1.========================================================

	Node binaryTreeToBST(Node root) {
		List<Integer> ans = new ArrayList<>();
		dataSet(root, ans);
		Collections.sort(ans);
		Conversion(root, ans, new Node(0));
		return root;
	}

	public static void dataSet(Node node, List<Integer> ans) {

		if (node == null)
			return;

		ans.add(node.data);
		dataSet(node.left, ans);
		dataSet(node.right, ans);
	}

	public static void Conversion(Node node, List<Integer> ans, Node idx) {
		if (node == null)
			return;
		Conversion(node.left, ans, idx);
		node.data = ans.get(idx.data);
		idx.data = idx.data + 1;
		Conversion(node.right, ans, idx);
	}

	// method2.===========================================================

}
