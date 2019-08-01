package Tree;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class Pairs_violating_BST_property {
	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	// Store the inorder traversal of the binary tree in an array.
	// Now_count_all_the_pairs_such_that_a[i]_>_a[j]_for_i_<_j_which_is_number_of_inversions_in_the_array.

	// method1.==============================================================
	static int idx = -1;

	public int pairs(Node root) {
		int[] arr = new int[1000000];
		inoder(root, arr);
		return mergeSortInversion(0, idx, arr, new Integer[idx + 1]);
	}

	public void inoder(Node node, int[] arr) {
		if (node == null)
			return;
		inoder(node.left, arr);
		arr[++idx] = (node.data);
		inoder(node.right, arr);
	}

	public static int mergeSortInversion(int li, int ei, int[] arr, Integer[] temp) {
		int res = 0;

		if (li < ei) {
			int mid = (li + ei) >> 1;

			res += mergeSortInversion(li, mid, arr, temp);
			res += mergeSortInversion(mid + 1, ei, arr, temp);

			res += mergeInversion(li, mid, ei, arr, temp);

		}
		return res;
	}

	private static int mergeInversion(int li, int mid, int ei, int[] arr, Integer[] temp) {

		int i = li;
		int j = mid + 1;
		int k = li;

		int inversion = 0;
		while (i <= mid && j <= ei) { // merged SubArray with inversions.
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
				inversion += mid - i + 1;
			}
		}

		while (i <= mid) {
			temp[k++] = arr[i++];
		}

		while (j <= ei) {
			temp[k++] = arr[j++];
		}

		while (li <= ei) {
			arr[li] = temp[li++];
		}

		return inversion;
	}

	private class Counter {
		int value;
	}

	// method2.=======================================================================

	public int pairs_(Node root) {
		Counter counter = new Counter();
		pairs(root, counter);
		return counter.value;
	}

	private Vector<Integer> pairs(Node root, Counter counter) {
		if (root == null) {
			return new Vector<>();
		}
		Vector<Integer> lSet = pairs(root.left, counter);
		Vector<Integer> rSet = pairs(root.right, counter);

		for (Integer num : lSet) {
			if (num < root.data) {
				continue;
			}
			counter.value++;
		}

		for (Integer num : rSet) {
			if (num > root.data) {
				continue;
			}
			counter.value++;
		}

		for (Integer lNum : lSet) {
			for (Integer rNum : rSet) {
				if (rNum > lNum) {
					continue;
				}
				counter.value++;
			}
		}

		Vector<Integer> mSet = new Vector<>();
		mSet.add(root.data);
		mSet.addAll(lSet);
		mSet.addAll(rSet);

		return mSet;
	}

}
