package interview.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Pep_JavaIP_1Arrays_28MinimizeTheMaximumDifference {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int[] arr = new int[scn.nextInt()];
		for(int i = 0; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
		
		int k = scn.nextInt();
		System.out.println(solve(arr, k));
	}

	private static int solve(int[] arr, int k) {
		int res = 0;
		
		Arrays.sort(arr);
		
		// the max-diff is big - small, we are trying to minimize that
		int small = arr[0] + k; // an add only will help here to minimize the max-diff
		int big = arr[arr.length - 1] - k; // a subtract only is sensible here.
		
		// re-balance is important
		if(small > big){
			int temp = small ^ big;
			small = small ^ temp;
			big = big ^ temp;
		}
		
		for(int i = 1; i <= arr.length - 2; i++){
			// new small and big if we go with subtraction
			int sub = arr[i] - k;
			int newSmallOnSub = sub < small? sub: small;
			int newBigOnSub = big;
			
			// new small and big if we go with addition here
			int add = arr[i] + k;
			int newSmallOnAdd = small;
			int newBigOnAdd = add > big? add: big;
			
			// the option which keeps the max-diff minimized
			if(newBigOnSub - newSmallOnSub < newBigOnAdd - newSmallOnAdd){
				small = newSmallOnSub;
				big = newBigOnSub;
			} else {
				small = newSmallOnAdd;
				big = newBigOnAdd;
			}
		}
		
		// big - small represents the minimized max-diff after activities in area 1 to arr.length - 2
		// when k was added to first element while k was subtracted from last element
		// But initial max-diff can not be ignored - what if we added k to all elements?
		res = Math.min(arr[arr.length - 1] - arr[0], big - small);
		
		return res;
	}

}
