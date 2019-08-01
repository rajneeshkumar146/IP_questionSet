package SearchingSorting;

import java.util.Scanner;

public class Pep_JavaIP_2SnS_593WayPartition {
/*What : Given a an array(sI,eI) with lots of repetition, sort it efficiently
*HOW :
* Apply QuickSort but in partitionining code, use Dutch national Flag idea.
* partition the array in three areas.Math interval notation
*	[0, lo - 1] : elements < pivot
*	[lo, mid - 1]: elements = pivot
*	[mid, high] : unknown area
*	[high + 1, arr.length -1] : elements > pivot
* Why :
* In simple QuickSort algorithm, we select an element as pivot,
*partition the array around pivot and recur for subarrays on left and right of pivot.
* Consider an array which has many redundant elements.
*For example, {1, 4, 2, 4, 2, 4, 1, 2, 4, 1, 2, 2, 2, 2, 4, 1, 4, 4, 4}.
* If 4 is picked as pivot in Simple QuickSort,we fix only one 4 and recursively
* process remaining occurrences.
*
*/
public static int[] partition(int[] arr, int sI, int eI) {

	int pivot = arr[eI];
	int low = sI;
	int mid = sI;
	int high = eI;

	while (mid <= high) {

		if (arr[mid] == pivot) {
			mid++;
		} else if (arr[mid] > pivot) {
			swap(arr, mid, high);
			high--;
		} else {
			swap(arr, mid, low);
			low++;
			mid++;
		}
	}
	int[] indices = { low, mid };
	return indices;
}

public static void threeWayQuickSort(int[] arr, int sI, int eI) {

	if (sI < eI) {

		int[] pivotIndices = partition(arr, sI, eI);

		threeWayQuickSort(arr, sI, pivotIndices[0] - 1);
		threeWayQuickSort(arr, pivotIndices[1], eI);
	}
}

public static void swap(int[] arr, int i, int j) {
	int temp = arr[j];
	arr[j] = arr[i];
	arr[i] = temp;
}

public static void printArr(int[] arr) {
	for (int n : arr) {
		System.out.print(n + " ");
	}
	System.out.println();
}

public static void main(String[] args) {
	Scanner scn = new Scanner(System.in);

	int test = scn.nextInt();
	while (test-- > 0) {

		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		threeWayQuickSort(arr, 0, arr.length - 1);
		printArr(arr);
	}
}

}
/*

Test cases:
	10
	1 1 4 4 5 2 3 9 5 4
	-----------------------
	1 1 2 3 4 4 4 5 5 9


	10
	1 1 4 4 5 6 3 9 5 4
	-----------------------
	1 1 3 4 4 4 5 5 6 9

	10
	1 1 4 4 5 2 3 9 5 10
	-----------------------
	1 1 2 3 4 4 5 5 9 10

	Source: https://www.geeksforgeeks.org/3-way-quicksort-dutch-national-flag/



*/
