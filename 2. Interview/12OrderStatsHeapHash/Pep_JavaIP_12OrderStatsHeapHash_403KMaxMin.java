package OrderStatsHeapHash;

import java.util.Arrays;
import java.util.Scanner;

public class Pep_JavaIP_12OrderStatsHeapHash_403KMaxMin {

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
		int odiff = Integer.MAX_VALUE;
		while (hi < arr.length) {
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