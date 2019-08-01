package pep_sns;

public class rotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] arr = { 5, 1, 2, 3, 4 };
		// long[] arr = { 2, 2, 2, 2, 1, 2 };
		// long[] arr = { 2, 1, 2, 2, 2 };
		int n = arr.length;
		int indx = 0;
		if (arr[0] < arr[n - 1]) {
			System.out.println("0");
		} else {
			indx = bsearch(arr);
			System.out.println(indx + 1);
		}

	}

	public static int bsearch(long[] arr) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (mid < right && arr[mid] > arr[mid + 1]) {
				return mid;
			}
			if (mid > left && arr[mid - 1] > arr[mid]) {
				return mid - 1;
			}
			if (arr[mid] < arr[left]) {
				right = mid - 1;
			} else if (arr[mid] > arr[left]) {
				left = mid + 1;
			} else {
				int i1 = mid;
				int i2 = mid;
				while (i1 > left && arr[i1] == arr[left]) {
					i1--;
				}
				while (i2 < right && arr[i2] == arr[left]) {
					i2++;
				}
				if (arr[i1] < arr[i2]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}
		return left;
	}

}
