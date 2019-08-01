package pep_sns;

public class count_zeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 1, 1, 0, 0};
		//LOG N
		int left = 0;
		int right = arr.length - 1;
		int idx = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] == 0 && (mid == 0 || ( mid - 1 >= 0 && arr[mid - 1] == 1))) {
				idx = mid;
				break;
			} else if (arr[mid] == 1)
				left = mid + 1;
			else
				right = mid - 1;
		}
		System.out.println(arr.length - idx);

	}

}
