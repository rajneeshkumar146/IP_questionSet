package misc;

public class MaxXorOfTwoNumbersInArray {

	TrieNode root;

	class TrieNode {
		TrieNode[] children;
		int val;

		public TrieNode() {
			children = new TrieNode[2];
		}

	}

	public MaxXorOfTwoNumbersInArray() {
		root = new TrieNode();
	}

	public void insert(int x) {

		TrieNode curr = root;
		for (int i = 31; i >= 0; i--) {
			int j = (x & (1 << i)) == 0 ? 0 : 1;
			if (curr.children[j] == null) {
				curr.children[j] = new TrieNode();
			}
			curr = curr.children[j];
		}
		curr.val = x;

	}

	public int getLargest(int x) {

		TrieNode curr = root;
		for (int i = 31; i >= 0; i--) {
			int j = (x & (1 << i)) == 0 ? 1 : 0;
			if (curr.children[j] == null) {
				j = 1 - j;
			}
			curr = curr.children[j];
		}

		return curr.val;

	}

	public int findMaximumXor(int[] num) {
		for (int x : num) {
			this.insert(x);
		}
		int max = 0;
		for (int x : num) {
			max = Math.max(max, x ^ this.getLargest(x));
		}

		return max;

	}

	public static void main(String[] args) {

		MaxXorOfTwoNumbersInArray obj = new MaxXorOfTwoNumbersInArray();
		int[] ar = { 3, 10, 5, 25, 2, 8 };
		System.out.println(obj.findMaximumXor(ar));
	}

}
