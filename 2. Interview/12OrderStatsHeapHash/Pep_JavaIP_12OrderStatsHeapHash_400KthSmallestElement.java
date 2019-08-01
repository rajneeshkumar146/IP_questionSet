package OrderStatsHeapHash;

import java.util.Arrays;
import java.util.Scanner;

public class Pep_JavaIP_12OrderStatsHeapHash_400KthSmallestElement {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		// Remove these array elements from the series of natural numbers and then print
		// the kth smallest element from
		// the series.
		// We know there would be some elements between arr[0]-1
		// and at arr[i+1] - arr[i] -1 would be number of elements between arr[i+1] to
		// arr[i]

		int k = scn.nextInt();

		ksmallest(arr, k);
	}

	private static void ksmallest(int[] arr, int k) {
		// Sort the array
		Arrays.sort(arr);
		
		//obvious base cases
		if (k < arr[0]) {
			System.out.println(k);
			return;
		}


		if (k > arr[arr.length - 1]) {
			System.out.println(k + arr.length);
			return;
		}

		int count = arr[0] - 1;
		if (k <= count) {
			printKsmallest(0, arr[0], k);
		} else {
			k -= count;
		}

		for (int i = 1; i < arr.length; i++) {
			count = arr[i] - arr[i - 1] - 1;
			if (k <= count) {
				printKsmallest(arr[i - 1], arr[i], k);
				return;
			} else {
				k -= count;
			}
		}
		//handles test case no 3
		System.out.println(arr[arr.length-1]+k);
	}

	private static void printKsmallest(int i, int j, int k) {
		int lp = 0;
		for (lp = i + 1; lp < j; lp++) {
			k--;
			if (k == 0) {
				System.out.println(lp);
				break;
			}
		}
	}

}

/*Test Cases:
	
6
1 5 15 20 25 8
8
``````````
11

1
1
1
```````````````
2

5
1 2 3 4 5
2
```````````
7

2
1 3
4
`````````````
6

Source: https://www.geeksforgeeks.org/k-th-smallest-element-removing-integers-natural-numbers/
*/