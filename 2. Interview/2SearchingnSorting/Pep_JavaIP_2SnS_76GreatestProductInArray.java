package SearchingSorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_2SnS_76GreatestProductInArray {
/*What : Given an array find the largest number possible which can be formed
* by product of two of its elements
*
*HOW : Sort array, Build freqMap of elements. Start from largest number in array
* check if its two factors are present in array.Fix one factor and find another by
* factor2 = arr[i] / factor1
*If factors not found , find factors of next largest element..so on
*
*WHY :
*Let n = p * q, then we can imply p <= sqrt(n) || q <= sqrt(n).
*In case when both factors equal, frequency must be > 2.
*Ex: 2 * 2 = 4, and 4 is largest in array, then we must have two 2's.
*/
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		HashMap<Integer, Integer> map = new HashMap();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i]) == false)
				map.put(arr[i], 1);
			else {
				map.put(arr[i], map.get(arr[i]) + 1);
			}
		}
		Arrays.sort(arr);
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = 0; j < i && arr[j] <= Math.sqrt(arr[i]); j++) {
				if (arr[i] % arr[j] == 0) {
					int result = arr[i] / arr[j];
					if (map.containsKey(result) && result != arr[j]) {
						if (map.get(result) > 0) {
							System.out.println(arr[i]);
							return;
						}
						/*for case when both factors are same. ex : 2 * 2 = 4*/
					} else if (map.containsKey(result) && result == arr[j]) {
						if (map.get(result) > 1) {
							System.out.println(arr[i]);
							return;
						}
					}
				}
			}
		}

		System.out.println(-1);
	}

}

/*
 * Test cases:
 * 5
 * 17 2 1 35 30
 * ------------------
 * 35
 *
 *5
10 2 4 30 35
------------------
-1


 6
10 2  2 4 30 35
------------------
4

Source: https://www.geeksforgeeks.org/find-pair-with-greatest-product-in-array/
 *
 *
 */
