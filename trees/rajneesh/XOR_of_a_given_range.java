package Tree;

public class XOR_of_a_given_range {

	// method_01.=========================================================

	public static int gXOR(int arr[], int n, int l, int r) {
		int val = 0;
		for (int i = l; i <= r; i++) {
			val ^= arr[i];
		}
		return val;
	}

	// method_02.=========================================================

	public static int fillSegmentTree(int[] segmentTree, int[] arr, int low, int high, int pos) {

		if (low == high) {
			segmentTree[pos] = arr[low];
			return arr[low];
		}
		int mid = low + ((high - low) >> 1);
		segmentTree[pos] = fillSegmentTree(segmentTree, arr, low, mid, (pos << 1) + 1)
				^ fillSegmentTree(segmentTree, arr, mid + 1, high, (pos << 1) + 2);
		return segmentTree[pos];
	}

	public static int getXORFromSegmentTree(int[] segmentTree, int low, int high, int l, int r, int pos) {
		if (l <= low && r >= high) { // lie inside.
			return segmentTree[pos];
		}
		if (l > high || r < low) { // lie outside
			return 0;
		}
		int mid = low + ((high - low) >> 1);
		return getXORFromSegmentTree(segmentTree, low, mid, l, r, (pos << 1) + 1)
				^ getXORFromSegmentTree(segmentTree, mid + 1, high, l, r, (pos << 1) + 2);
	}

	public static int gXOR_(int arr[], int n, int l, int r) {

		int tmp, size;
		if ((n & n - 1) != 0) {
			tmp = (int) (Math.log(n) / Math.log(2));
			size = (1 << (tmp + 1));
		} else {
			size = n;
		}

		size = size * 2 - 1;

		int[] segmentTree = new int[size];

		fillSegmentTree(segmentTree, arr, 0, n - 1, 0);

		return getXORFromSegmentTree(segmentTree, 0, n - 1, l, r, 0);
	}
}
