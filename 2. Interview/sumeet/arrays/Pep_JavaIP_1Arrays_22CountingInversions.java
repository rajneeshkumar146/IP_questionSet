package interview.arrays;

import java.util.Scanner;

public class Pep_JavaIP_1Arrays_22CountingInversions {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int[] aux = new int[arr.length];
		int result = solve(arr, aux, 0, arr.length - 1);
		System.out.println(result);
	}

	public static int solve(int[] arr, int[] aux, int lo, int hi) {
		if (arr.length == 1 || arr.length == 0) {
			return 0;
		}
		if (lo == hi) {
			return 0;
		}

		int mid = (lo + hi) / 2;
		int f1 = solve(arr, aux, lo, mid);
		int f2= solve(arr, aux, mid + 1, hi);

		// there are 2 arrays in this : one from lo to mid and other from mid+1 to hi
		int f3= merge(arr, aux, lo, mid + 1, hi);

		return f1+f2+f3;
	}

	// Merge step of MergeSort
	public static int merge(int arr[], int aux[], int lo, int mid, int hi) {
		int i, j, k;
		int count = 0;

		i = lo; // first half from i to mid - 1, inclusive
		j = mid; // second half from mid to hi, inclusive
		k = lo;
		while ((i <= mid - 1) && (j <= hi)) {
			if (arr[i] <= arr[j]) {
				aux[k] = arr[i];
				k++;
				i++;
			} else {
				aux[k] = arr[j];
				k++;
				j++;
				count += mid - i; // all elements from first half after i are also larger than j.
			}
		}

		while (i <= mid - 1) {
			aux[k] = arr[i];
			k++;
			i++;
		}

		while (j <= hi) {
			aux[k] = arr[j];
			k++;
			j++;
		}

		for (i = lo; i <= hi; i++)
			arr[i] = aux[i];

		return count;
	}
}
