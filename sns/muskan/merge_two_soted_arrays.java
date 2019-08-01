package pep_sns;

public class merge_two_soted_arrays {

	// o1 space
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 4;
		int n = 5;
		int[] arr1 = { 1, 3, 5, 7 };
		int[] arr2 = { 0, 2, 6, 8, 9 };
		for (int i = 0; i < m; i++) {
			if (arr1[i] > arr2[0]) {
				int temp = arr1[i];
				arr1[i] = arr2[0];
				arr2[0] = temp;
				int val = arr2[0];
				int j;
				for (j = 1; j < n && arr2[j] < val; j++) {
					arr2[j - 1] = arr2[j];
				}
				arr2[j - 1] = val;
			}
		}
		for (int i = 0; i < m; i++) {
			System.out.print(arr1[i] + " ");
		}
		for (int i = 0; i < n; i++) {
			System.out.print(arr2[i] + " ");
		}
	}
}
