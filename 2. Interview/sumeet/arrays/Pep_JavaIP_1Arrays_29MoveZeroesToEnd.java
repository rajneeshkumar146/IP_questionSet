package interview.arrays;

import java.util.Scanner;

public class Pep_JavaIP_1Arrays_29MoveZeroesToEnd {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		solve(arr);
	}

	private static void solve(int[] arr) {
		int countNZ = 0;
		
		// i is the traveller idx, 
		// countNZ is the index that counts how many != 0 values have been encountered
		for(int i = 0; i < arr.length; i++){
			if(arr[i] != 0){
				// countNZ collects !0 elements behind it
				int temp = arr[countNZ];
				arr[countNZ] = arr[i];
				arr[i] = temp;
				
				countNZ++;
			}
		}
		
		for(int val: arr){
			System.out.print(val + " ");
		}
	}

}
