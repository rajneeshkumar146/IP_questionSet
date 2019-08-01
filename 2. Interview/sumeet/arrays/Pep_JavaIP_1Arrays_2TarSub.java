package interview.arrays;

import java.util.Scanner;

public class Pep_JavaIP_1Arrays_2TarSub {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int tar = scn.nextInt();
		
		int[] arr = new int[n];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		
		solve(tar, arr);
	}

	private static void solve(int tar, int[] arr) {
		int start = 0;
		int end = 0;
		int sum = arr[0];
		
		while(start < arr.length && end < arr.length) {
			if(sum < tar) {
				end++;
				sum += arr[end];
			} else if(sum > tar) {
				sum -= arr[start];
				start++;
			} else {
				for(int i = start; i <= end; i++) {
					System.out.print(arr[i] + " ");
				}
//				System.out.println(".");
				return;
			}
		}
		
		System.out.println("Not found");
	}

}
