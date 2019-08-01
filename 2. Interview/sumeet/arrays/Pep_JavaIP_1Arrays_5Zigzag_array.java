package interview.arrays;

import java.util.Scanner;

public class Pep_JavaIP_1Arrays_5Zigzag_array {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		
		solve(arr);
	}

	private static void solve(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			if(i % 2 == 0) {
				if(arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			} else {
				if(arr[i] < arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			}
//			
//			if((i % 2 == 0) ^ (arr[i] < arr[i + 1])) {
//				swap(arr, i, i + 1);
//			}
		}
		
		for(int val: arr) {
			System.out.print(val + " ");
		}
		System.out.println();
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i] ^ arr[j];
		arr[i] ^= temp;
		arr[j] ^= temp;
	}

}
