package OrderStatsHeapHash;

import java.util.Arrays;
import java.util.Scanner;

public class Pep_JavaIP_12OrderStatsHeapHash_404KClosestElements {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int k = scn.nextInt();
		int X = scn.nextInt();

		int[] arr = new int[scn.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		Arrays.sort(arr);

		int z = Arrays.binarySearch(arr, X);
		System.out.println(z);

		int lp = z - 1, rp = z + 1;

		while (lp >= 0 && rp < arr.length && k > 0) {
			if (arr[z] - arr[lp] < arr[rp] - arr[z]) {
				System.out.println(arr[lp]);
				lp--;
				k--;
			} else {
				System.out.println(arr[rp]);
				rp++;
				k--;
			}

		}

		while (lp > 0 && k > 0) {
			System.out.println(arr[lp]);
			lp--;
			k--;
		}

		while (rp < arr.length && k > 0) {
			System.out.println(arr[rp]);
			rp++;
			k--;
		}

	}

}

/*Test Cases:
	 4 35
     12 16 22 30 35 39 42 
     45 48 50 53 55 56
Output: 30 39 42 45

5 24
5
21 22 23 24 30
Output: 23 22 21 30 
This answer is valid only if element is present in the array.

Source: https://www.geeksforgeeks.org/find-k-closest-elements-given-value/



*/
