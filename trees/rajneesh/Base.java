package Tree;

import java.util.ArrayDeque;

public class Base {

	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int data, TreeNode left, TreeNode right) {
			this.val = data;
			this.left = left;
			this.right = right;
		}

		public TreeNode(int data) {
			this.val = data;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();

			sb.append(left != null ? left.val : ".");
			sb.append(" -> " + val + " <- ");
			sb.append(right != null ? right.val : ".");
			sb.append("\n");

			if (left != null)
				sb.append(left);
			if (right != null)
				sb.append(right);

			return sb.toString();
		}
	}

	// constructor.=====================================================

	public static TreeNode constructor_PureLvelOderSerailize(int[] arr) {
		TreeNode[] Tree = new TreeNode[arr.length];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != -1) {
				TreeNode node = new TreeNode(arr[i], null, null);
				Tree[i] = node;
				if (i == 0)
					continue;

				int par = (i - 1) >> 1;

				if (((par << 1) + 1) == i) {
					Tree[par].left = node;
				} else {
					Tree[par].right = node;
				}

			}
		}

		return Tree[0];
	}

	public static TreeNode constructor_levelOderSerailize(Integer[] arr) {
		ArrayDeque<TreeNode> que = new ArrayDeque<>();
		TreeNode root = new TreeNode(arr[0]);
		que.addLast(root);
		int i = 1;
		while (!que.isEmpty() && i < arr.length) {
			TreeNode nn = que.removeFirst();

			if (i < arr.length && arr[i] != null) {
				TreeNode n = new TreeNode(arr[i]);
				nn.left = n;
				que.addLast(n);
			}
			i++;

			if (i < arr.length && arr[i] != null) {
				TreeNode n = new TreeNode(arr[i]);
				nn.right = n;
				que.addLast(n);
			}
			i++;
		}

		return root;
	}

	public static TreeNode constructor_preOderSerialize(int[] arr, TreeNode idx) {
		if (idx.val >= arr.length || arr[idx.val] == -1) {
			idx.val++;
			return null;
		}

		TreeNode node = new TreeNode(arr[idx.val]);
		idx.val++;
		node.left = constructor_preOderSerialize(arr, idx);
		node.right = constructor_preOderSerialize(arr, idx);
		return node;
	}

	// generalUtil.============================================

	public static Integer[] inputSplitSpace(String str) {
		String[] sArr = str.split(" ");
		Integer[] arr = new Integer[sArr.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sArr[i].equals("null") ? null : Integer.parseInt(sArr[i]);
		}
		return arr;
	}

	public static void display(int[] arr) {
		for (int i : arr)
			System.out.print(i + " ");

		System.out.println();
	}

	public static void removeComma(String str) {
		String[] sArr = str.split(",");
		for (String s : sArr)
			System.out.print(s + " ");

		System.out.println();
	}
}
