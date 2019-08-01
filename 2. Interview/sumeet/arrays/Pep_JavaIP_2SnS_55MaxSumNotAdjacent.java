package interview.arrays;

import java.util.Scanner;

public class Pep_JavaIP_2SnS_55MaxSumNotAdjacent {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int[] arr = new int[scn.nextInt()];
		for(int i = 0; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
		
		solve(arr);
	}

	private static void solve(int[] arr) {
		int inc = arr[0]; // first item included
		int exc = 0; // first item excluded
		
		for(int i = 1; i < arr.length; i++){
			// this item can be included only with last exclusion
			int nexInc = exc + arr[i]; 
			// this item can be excluded, in both cases - if last was included or excluded
			// we'll go with the better option
			int nexExc = Math.max(exc, inc); 
			
			inc = nexInc;
			exc = nexExc;
		}
		
		System.out.println(Math.max(inc, exc));
	}
}
