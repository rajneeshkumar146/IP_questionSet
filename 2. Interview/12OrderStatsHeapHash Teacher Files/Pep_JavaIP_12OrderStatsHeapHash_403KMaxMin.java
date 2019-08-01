package OrderStatsHeapHash;

import java.util.Arrays;
import java.util.Scanner;
/*
*Choose k elements such that max - min , is minimized
 */
public class Pep_JavaIP_12OrderStatsHeapHash_403KMaxMin {
/* 
*1.Sort the Array.
*2.Calculate the maximum(k numbers) – minimum(k numbers) for each group of k consecutive integers.
*3.Return minimum of all values obtained in step 2.
*/

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		Arrays.sort(arr);

		int lo = 0;
		int hi = k - 1;
		// as we have to minimize difference
		int odiff = Integer.MAX_VALUE;
		//iterate over k-sized windows
		while (hi < arr.length) {
			//Difference between max and min of current window
			int diff = arr[hi] - arr[lo];
			if (diff < odiff) {
				odiff = diff;
			}
			hi++;
			lo++;
		}

		System.out.println(odiff);
	}

}
/*
Test cases:
	7
	10 20 30 100 200 300 1000
	3
	---------------
	20
	
	7
	10 20 30 100 200 300 1000
	4
	--------------
	90
	
	3
	4 5 1
	2
	--------------
	1
	
	Source: https://www.geeksforgeeks.org/k-numbers-difference-maximum-minimum-k-number-minimized/


	
*/