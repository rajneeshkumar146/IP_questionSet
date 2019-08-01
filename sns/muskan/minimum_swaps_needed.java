package pep_sns;

public class minimum_swaps_needed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 4, 4, 2, 3, 9, 6 };
		int n = arr.length;

		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
