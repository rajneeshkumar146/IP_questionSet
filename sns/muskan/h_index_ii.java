package pep_sns;

public class h_index_ii {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] citations = { 0, 1, 2, 3, 5, 6 };
		// 0, 1, 2, 5, 6 => ans : 2
		System.out.println(hIndex(citations));
	}

	public static int hIndex(int[] citations) {
		int left = 0;
		int right = citations.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (citations[mid] == citations.length - mid) {
				return citations[mid];
			}
			if (citations[mid] > citations.length - mid) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return citations.length - left;
	}

}
