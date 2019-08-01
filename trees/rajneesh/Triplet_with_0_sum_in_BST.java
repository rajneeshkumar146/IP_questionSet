package Tree;

import java.util.ArrayList;

public class Triplet_with_0_sum_in_BST {

	class Node {
		int data;
		Node left, right;

		Node(int key) {
			data = key;
			left = right = null;
		}
	}

	static ArrayList<Integer> list = new ArrayList<Integer>();
	static int sum = 0;

	public static boolean isTriplet(Node root) {
		list = new ArrayList<>();
		Inorder(root);
		boolean res = isTripletUtil(root, sum);
		return res;

	}

	public static void Inorder(Node root) {
		if (root == null)
			return;

		Inorder(root.left);
		list.add(root.data);
		Inorder(root.right);
	}

	public static boolean isTripletUtil(Node root, int sum) {
		for (int i = 0; i < list.size() - 1; i++) {
			int j = i + 1;
			int k = list.size() - 1;
			while (j < k) {
				if (list.get(i) + list.get(j) + list.get(k) < sum) {
					j++;
				} else if (list.get(i) + list.get(j) + list.get(k) > sum) {
					k--;
				} else {
					return true;
				}
			}
		}
		return false;
	}

}
