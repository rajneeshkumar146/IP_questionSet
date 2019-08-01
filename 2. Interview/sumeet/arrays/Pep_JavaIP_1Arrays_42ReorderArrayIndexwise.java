package interview.arrays;

import java.util.Scanner;

public class Pep_JavaIP_1Arrays_42ReorderArrayIndexwise {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int[] arr = new int[scn.nextInt()];
		for(int i = 0; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
		
		int[] idxes = new int[arr.length];
		for(int i = 0; i < idxes.length; i++){
			idxes[i] = scn.nextInt();
		}
		
		solve(arr, idxes);
	}

	private static void solve(int[] arr, int[] idxes) {
		int i = 0;
		
		while(i < arr.length){
			if(i != idxes[i]){ // if it is not proper index yet, swap in both arrays
				swap(arr, i, idxes[i]); // this swap should happen first
				swap(idxes, i, idxes[i]);
			} else {
				i++;
			}
		}
		
		for(int val: arr){
			System.out.print(val + " ");
		}
		System.out.println();
	}
	
	private static void swap(int[] arr, int i, int j){
		int temp = arr[i] ^ arr[j];
		arr[i] = temp ^ arr[i];
		arr[j] = temp ^ arr[j];
	}
}
