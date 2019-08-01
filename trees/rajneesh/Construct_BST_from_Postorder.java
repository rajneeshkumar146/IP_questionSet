package Tree;

public class Construct_BST_from_Postorder {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode bstFromPreorder(int[] preorder) {
		idx = 0;
		return preOder(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	static int idx = 0;
	public static TreeNode preOder(int[] arr, int min, int max) {
		if (idx >= arr.length)
			return null;
		
		TreeNode node = null;
		int ele = arr[idx];
		
		if (ele > min && ele < max) {
			node = new TreeNode(ele);
			idx++;

			node.left = preOder(arr, min, ele);
			node.right = preOder(arr, ele, max);
		}
		return node;
	}

}
