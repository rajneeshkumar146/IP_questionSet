package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Closest_Binary_Search_Tree_Value_II {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void closestKValues_(TreeNode root, double target, int k, LinkedList<Integer> ans) {
		if (root == null)
			return;

		closestKValues_(root.left, target, k, ans);
		if (ans.size() < k) {
			ans.add(root.val);
		} else if (Math.abs(root.val - target) < Math.abs(ans.getFirst() - target)) {
			ans.removeFirst();
			ans.add(root.val);
		}

		closestKValues_(root.right, target, k, ans);

	}

	public static List<Integer> closestKValues(TreeNode root, double target, int k) {
		LinkedList<Integer> ans = new LinkedList<Integer>();
		List<Integer> ans1 = new ArrayList<>();
		closestKValues_(root, target, k, ans);

		while (ans.size() > 0) {
			ans1.add(ans.removeLast());
		}

		return ans1;

	}

	
	/*
	 * This approach is similar to finding smallest k elements in the array
	 * using a max heap of k. In that approach, we compare the next element with
	 * the peek of the max heap. If it's less than peek, we poll the peek and
	 * add this element. But in this case, we are using just a LinkedList
	 * instead of PriorityQueue and comparing with the first element in the
	 * queue.
	 * 
	 * Basically, we want to make sure that
	 * 
	 * Whenever we remove from res, it should the element with largest
	 * difference with target among those k elements
	 * 
	 * Its somehow achieving the purpose without Prioirty Queue. Let's see how:
	 * 
	 * If we use a priority queue, we are not using the property that this
	 * binary tree is a BST too. The solution with priority queue will work on
	 * binary tree, not just BST.
	 * 
	 * Since we have BST here, we can traverse the elements in a ordered manner,
	 * specifically in increasing order if we do in-order traversal. This
	 * property allows us to use a normal queue instead of a special priority
	 * queue.
	 * 
	 * https://dl2.pushbulletusercontent.com/upSPoZDjlU3pO0yx1ggEf46Zv8xDvHgb/IMG_20190422_195218.jpg
	 * 
	 * 
	 */
	
}
