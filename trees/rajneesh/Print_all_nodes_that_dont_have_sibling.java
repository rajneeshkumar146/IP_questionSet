package Tree;

import java.util.ArrayList;
import java.util.Collections;

public class Print_all_nodes_that_dont_have_sibling {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}

	}

	void printSibling(Node node) {
		ArrayList<Integer> ans = new ArrayList<>();
		printSibling_(node, ans);
		if (ans.size() > 0) {
			Collections.sort(ans);
			for (Integer i : ans) {
				System.out.print(i + " ");
			}
		} else {
			System.out.print(-1);
		}
	}

	void printSibling_(Node node, ArrayList<Integer> ans) {
		if (node == null)
			return;

		if (node.left == null && node.right == null)
			return;
		if (node.left == null || node.right == null)
			ans.add(node.right != null ? node.right.data : node.left.data);

		printSibling_(node.left, ans);
		printSibling_(node.right, ans);

	}
}
