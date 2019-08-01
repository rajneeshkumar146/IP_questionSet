package pep_sns;

public class bubble_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 7, 6, 3, 1, 5, 3, 9 };
		bubble(arr, arr.length);
		for(int val:arr)
			System.out.print(val + " ");
	}

	public static void bubble(int arr[], int n) {
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < (n - i - 1); j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

}
