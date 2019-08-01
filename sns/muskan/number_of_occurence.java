package pep_sns;

public class number_of_occurence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 1, 1, 2, 2, 2, 2, 4, 5 };
		int n = 8;
		int x = 2;
		int leftidx = fox(arr, 0, n - 1, x);
		if (leftidx == -1) {
			System.out.println("-1");
		} else {
			int rightidx = lox(arr, 0, n - 1, x);
			System.out.println(rightidx - leftidx + 1);
		}

	}

	public static int fox(int[] arr, int left, int right, int x) {
		int li = -1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if ((mid == 0 || x > arr[mid - 1]) && x == arr[mid]) {
				li = mid;
				break;
			}
			if (x <= arr[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return li;
	}

	public static int lox(int[] arr, int left, int right, int x) {
		int ri = -1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if ((mid == arr.length - 1 || x < arr[mid + 1]) && x == arr[mid]) {
				ri = mid;
				break;
			}
			if (x >= arr[mid]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return ri;
	}

}
