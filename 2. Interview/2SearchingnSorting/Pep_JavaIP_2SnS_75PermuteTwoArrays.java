package SearchingSorting;

import java.util.Arrays;
import java.util.Scanner;

public class Pep_JavaIP_2SnS_75PermuteTwoArrays {
	/*What : Given two arrays and k, can we find a permutation of both arrays such
	* that for all i, arr1[i] + arr2[i] >= k
	*HOW :
	* Sort both arrays, pair each element from both arrays. Pick min element from
	*	first array, and max element from second array.
	* WHY :
	*Pair weakest of arr1 with strongest of arr2, if still can't beat k, then no
	*solution exists
	*
	*/
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		Arrays.sort(arr);
		int[] arr1 = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			arr1[i] = scn.nextInt();
		}
		int k=scn.nextInt();
		Arrays.sort(arr1);
		int left=0;
		int right=arr.length-1;
		while(left<arr.length) {
			if(arr[left]+arr1[right]<k) {
				System.out.println("No");
				return;
			}
			left++;
			right--;
		}

		System.out.println("Yes");

	}

}
/*
Test cases:
3
2 1 3
7 8 9
10
-----------------
Yes


4
2 1 6 5
4 7 8 9
10
----------------
Yes

6
10 19 8 11 15 9
6 5 4 3 2 1
20
--------------
No

Source: https://www.geeksforgeeks.org/permute-two-arrays-sum-every-pair-greater-equal-k/
*/
