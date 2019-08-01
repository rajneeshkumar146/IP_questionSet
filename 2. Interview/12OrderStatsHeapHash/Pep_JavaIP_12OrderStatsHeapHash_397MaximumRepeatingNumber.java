package OrderStatsHeapHash;

import java.util.Scanner;

public class Pep_JavaIP_12OrderStatsHeapHash_397MaximumRepeatingNumber {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		int k = scn.nextInt();

		for (int i = 0; i < arr.length; i++) {
			arr[arr[i] % k] += k;
		}
		
		int max=Integer.MIN_VALUE;
		int pos=0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]>max) {
				max=arr[i];
				pos=i;
			}
		}
		
		System.out.println(pos);
	}

}
/*
Test Cases: 
8
2 3 3 5 3 4 1 7
8
3

Source : https://www.geeksforgeeks.org/find-the-maximum-repeating-number-in-ok-time/
*/
