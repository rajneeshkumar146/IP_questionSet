package SearchingSorting;

import java.util.Scanner;

public class Pep_JavaIP_2SnS_68ProductArrayPuzzle {
	/* What : Given a array, construct a product array of equal length such that
	*product[i] : contains product of all elements except arr[i]
	*Constraint : No use of division operator
	*HOW : Construct two arrays left and right, for all i, ans is left[i]*right[i]
	*
	* WHY :
	* left[i] contains product of all elements to the left of arr[i] exclusive
	* right[i] contains product of all elements to the right of arr[i] exclusive
	*/
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int[] arr = new int[scn.nextInt()];
		for (int i1 = 0; i1 < arr.length; i1++) {
			arr[i1] = scn.nextInt();
		}

		//left[i] contains product of all elements to the left of arr[i] exclusive
		int[] left=new int[arr.length];
		left[0]=1;
		for(int i=1; i<arr.length; i++) {
			left[i]=left[i-1]*arr[i-1];
		}

		//right[i] contains product of all elements to the left of arr[i] exclusive
		int[] right=new int[arr.length];
		right[arr.length-1]=1;
		for(int i=arr.length-2; i>=0; i--) {
			right[i]=right[i+1]*arr[i+1];
		}

		for(int i=0; i<arr.length; i++) {
			arr[i]=left[i]*right[i];
		}

		for(int val: arr) {
			System.out.print(val+" ");
		}

	}

}

/*
Test cases
5
10 3 5 6 2
-------------------
180 600 360 300 900

5
13 14 -15 17 -16
------------------
57120 53040 -49504 43680 -46410


10
1 2 3 -4 -5 6 7 8 9 10
-------------------------
3628800 1814400 1209600 -907200 -725760 604800 518400 453600 403200 362880

Source: https://www.geeksforgeeks.org/a-product-array-puzzle/
*/
