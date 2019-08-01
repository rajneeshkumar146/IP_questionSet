package SnS;

public class smallest_positive_missing_number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {0,-10,1,3,-20};
		System.out.println(findMissing(arr,arr.length));
	}

	static int findMissing(int arr[], int size) {
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= 0) {
				swap(arr, i, j);
				j++;
			}
		}

		int[] arr2 = new int[size - j];
		int k = 0;
		for (int i = j; i < size; i++) {
			arr2[k++] = arr[i];
		}

		for (int i = 0; i < arr2.length; i++) {
			int val = Math.abs(arr2[i]);
			if (val - 1 < arr2.length && arr2[val - 1] > 0) {
				arr2[val - 1] = -arr2[val - 1];
			}
		}

		for (int i = 0; i < arr2.length; i++) {
			if (arr2[i] > 0) {
				return i + 1;
			}
		}

		return arr2.length + 1;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
