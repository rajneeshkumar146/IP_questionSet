package interview.arrays;

import java.util.Scanner;

public class Pep_JavaIP_2SnS_58MergeTwoSortedArrays {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int[] one = new int[scn.nextInt()];
		for (int i = 0; i < one.length; i++) {
			one[i] = scn.nextInt();
		}

		int[] two = new int[scn.nextInt()];
		for (int i = 0; i < two.length; i++) {
			two[i] = scn.nextInt();
		}

		modifiedHeapSort(one, two);

		for (int val : one) {
			System.out.print(val + " ");
		}
		System.out.println();

		for (int val : two) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

	private static void modifiedHeapSort(int[] one, int[] two) {
		for (int i = (one.length + two.length) / 2 - 1; i >= 0; i--) {
			modifiedDownHeapify(one, two, i, one.length + two.length);
		}

		for (int i = one.length + two.length - 1; i > 0; i--) {
			modifiedSwap(one, two, 0, i);
			modifiedDownHeapify(one, two, 0, i);
		}
	}

	public static void modifiedDownHeapify(int[] one, int[] two, int pi, int hs) {
		int lci = 2 * pi + 1;
		int rci = lci + 1;

		int maxi = pi;
		if (lci < hs && modifiedCompareTo(one, two, lci, maxi) > 0) {
			maxi = lci;
		}

		if (rci < hs && modifiedCompareTo(one, two, rci, maxi) > 0) {
			maxi = rci;
		}

		if (maxi != pi) {
			modifiedSwap(one, two, pi, maxi);
			modifiedDownHeapify(one, two, maxi, hs);
		}
	}
	
	public static void modifiedSwap(int[] one, int[] two, int i, int j){
		int[] oneDash = i < one.length? one: two;
		int[] twoDash = j < one.length? one: two;
		
		int temp = oneDash[i % one.length] ^ twoDash[j % one.length];
		oneDash[i % one.length] ^= temp;
		twoDash[j % one.length] ^= temp;
	}
	
	public static int modifiedCompareTo(int[] one, int[] two, int i, int j){
		int[] oneDash = i < one.length? one: two;
		int[] twoDash = j < one.length? one: two;
		
		return oneDash[i % one.length] - twoDash[j % one.length];
	}

	// normal in-place heapsort (for reference)
	public static void heapSort(int[] arr) {
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			// creating a heap in O(n)
			downHeapify(arr, i, arr.length);
		}

		for (int i = arr.length - 1; i > 0; i--) {
			// Bringing largest element (the one at root), to its correct spot
			// downheapifying the rest of heap, to bring 2nd largest on root (0) now.
			swap(arr, 0, i);
			downHeapify(arr, 0, i);
		}
	}

	// normal in-place heapsort downheapify (for reference)
	public static void downHeapify(int[] arr, int pi, int hs) {
		int lci = 2 * pi + 1;
		int rci = lci + 1;

		int maxi = pi;
		if (lci < hs && arr[lci] > arr[maxi]) {
			maxi = lci;
		}

		if (rci < hs && arr[rci] > arr[maxi]) {
			maxi = rci;
		}

		if (maxi != pi) {
			swap(arr, pi, maxi);
			downHeapify(arr, maxi, hs);
		}
	}

	// normal in-place heapsort swap (for reference)
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i] ^ arr[j];
		arr[i] ^= temp;
		arr[j] ^= temp;
	}
}
