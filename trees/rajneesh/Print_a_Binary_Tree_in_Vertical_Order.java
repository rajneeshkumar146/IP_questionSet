package Tree;

import java.util.ArrayList;

public class Print_a_Binary_Tree_in_Vertical_Order {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}

	}

	static void verticalOrder(Node node) {
		int leftWidth = width(node, true);
		int rightWidth = width(node, false);

		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for (int i = 0; i <= leftWidth + rightWidth; i++)
			ans.add(new ArrayList<>());

		method_01_(node, leftWidth, ans);

		for (int i = 0; i < ans.size(); i++) {
			for (int j = 0; j < ans.get(i).size(); j++) {
				System.out.print(ans.get(i).get(j) + " ");
			}

		}

	}

	private static void method_01_(Node node, int width, ArrayList<ArrayList<Integer>> ans) {
		if (node == null)
			return;

		ans.get(width).add(node.data);
		method_01_(node.left, width - 1, ans);
		method_01_(node.right, width + 1, ans);
	}

	private static int width(Node node, boolean IsLeftWidth) {
		if (node == null)
			return -1;
		int left = width(node.left, IsLeftWidth) + (IsLeftWidth ? 1 : -1);
		int right = width(node.right, IsLeftWidth) + (IsLeftWidth ? -1 : 1);

		return Math.max(left, right);
	}

}
