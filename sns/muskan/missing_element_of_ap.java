package pep_sns;

public class missing_element_of_ap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { -28, -21, -7, 0 };
		int n = arr.length;

		int diff = (arr[n - 1] - arr[0]) / n;
		int left = 0;
		int right = n - 1;
		int ele = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] + diff != arr[mid + 1]) {
				ele = arr[mid] + diff;
				break;
			}
			if (arr[mid - 1] + diff != arr[mid]) {
				ele = arr[mid - 1] + diff;
				break;
			}
			// mid is n/2th element
			if (arr[mid] == arr[0] + mid * diff) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(ele);

	}

}
