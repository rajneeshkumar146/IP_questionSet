package Tree;

import java.util.HashMap;
import java.util.Scanner;

import Tree.Predecessor_and_Successor.Res;

public class Sum_of_the_Longest_Bloodline_of_a_Tree {

	static class Node {
		int data;
		Node left, right;

		Node(int key) {
			data = key;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			// int n = sc.nextInt();
			HashMap<Integer, Node> m = new HashMap<Integer, Node>();
			int n = sc.nextInt();
			Node root = null;
			while (n > 0) {

				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				char lr = sc.next().charAt(0);

				Node parent = m.get(n1);
				if (parent == null) {
					parent = new Node(n1);
					m.put(n1, parent);
					if (root == null)
						root = parent;
				}
				Node child = new Node(n2);
				if (lr == 'L')
					parent.left = child;
				else
					parent.right = child;
				m.put(n2, child);
				n--;
			}

			Sum_of_the_Longest_Bloodline_of_a_Tree gfg = new Sum_of_the_Longest_Bloodline_of_a_Tree();
			System.out.println(gfg.sumOfLongRootToLeafPath(root));

		}

	}

	// method_01====================================================================

	class Res {
		int maxSum = Integer.MIN_VALUE;
		int maxLen = 0;
	}

	public int sumOfLongRootToLeafPath(Node root) {
		Res r = new Res();
		Res s = new Res();
		if (root == null)
			return 0;

		// sumOfLongRootToLeafPathUtil(root, 0, 0, s, r);
		// return r.maxSum;

		return sumOfLongRootToLeafPathUtil_02(root, 0, 0).maxSum;

	}

	public void sumOfLongRootToLeafPathUtil(Node root, int sum, int len, Res s, Res r) {
		if (root == null) {
			if (s.maxLen < len) {
				s.maxLen = len;
				r.maxSum = sum;
			} else if (s.maxLen == len && r.maxSum < sum)
				r.maxSum = sum;

			return;
		}

		sumOfLongRootToLeafPathUtil(root.left, sum + root.data, len + 1, s, r);
		sumOfLongRootToLeafPathUtil(root.right, sum + root.data, len + 1, s, r);
	}

	// method_02================================================================================

	public Res sumOfLongRootToLeafPathUtil_02(Node root, int sum, int len) {
		if (root == null) {
			Res ans = new Res();
			ans.maxLen = len;
			ans.maxSum = sum;
			return ans;
		}

		Res left = sumOfLongRootToLeafPathUtil_02(root.left, sum + root.data, len + 1);
		Res right = sumOfLongRootToLeafPathUtil_02(root.right, sum + root.data, len + 1);

		Res ans = new Res();
		if (left.maxLen <= right.maxLen) {
			ans.maxLen = right.maxLen;
			ans.maxSum = right.maxSum;
		} else if (right.maxLen <= left.maxLen) {
			ans.maxLen = left.maxLen;
			ans.maxSum = left.maxSum;
		}

		if (left.maxLen == right.maxLen) {
			ans.maxSum = Math.max(left.maxSum, right.maxSum);
		}

		return ans;

	}

}
