package SearchingSorting;

import java.util.Scanner;

public class Pep_JavaIP_2SnS_70FindDuplicates {
/*What : Array with all elements in range [0, arr.length -1]
*HOW :
* go to index arr[i] % arr.length, increment it by arr.length
* Iterate again, if arr[i]/ arr.length > 1 , then i was repeating
*
*WHY :
* Since modn gives answers only in range [0,n-1], it maps indices with elements
* {3,3,3,1}, now arr[3] = 1, and 3 is repeating 3 times.
* arr[3] = 1 + 4 * 3 = 13, 13/4 > 1 , therefore 3 is repeating
* In general after iteration, arr[i] contains, old value + k*n
*	where k is number of times i repeats.
* 
*/
	static void printRepeating(int arr[]) {

		for (int i = 0; i < arr.length; i++) {
			int index = arr[i] % arr.length;
			arr[index] += arr.length;
		}
		for(int i = 0; i < arr.length; i++){
			if( (arr[i]/arr.length) > 1){
				System.out.print(i + " ");

			}
		}
	}

	// Driver program
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int[] arr = new int[scn.nextInt()];
		for (int i1 = 0; i1 < arr.length; i1++) {
			arr[i1] = scn.nextInt();
		}
		printRepeating(arr);
	}
}

/*
  Test cases
  5
  1 2 3 1 2
  -----------------
  1 2

  10
  2 2 3 4 5 6 7 8 8 0
  -------------------------
  2 8


  10
  1 2 3 4 5 6 7 8 8 0
  -------------------------
  8

  Source:
  https://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-
  space/
 */
