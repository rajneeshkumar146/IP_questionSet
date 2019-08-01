package interview.arrays;

import java.util.Scanner;

public class Pep_JavaIP_1Arrays_30BringLessThanKTogetherInMinSwaps {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int[] arr = new int[scn.nextInt()];
		for(int i = 0; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		
		System.out.println(solve(arr, k));
	}
	
	private static int solve(int[] arr, int k){
		int res = 0;
		
		// count elements <= k
		int countLessThanK = 0;
		for(int val : arr){
			if(val <= k){
				countLessThanK++;
			}
		}
		
		// count valid elements in first window (of size countLessThanK)
		int countKsInWindow = 0;
		for(int i = 0; i < countLessThanK; i++){
			if(arr[i] <= k){
				countKsInWindow++;
			}
		}
		
		// sliding the window and trying to find the window with maximum valid elements
		// that one will require minimum swaps
		int maxKsInWindow = countKsInWindow;
		for(int i = countLessThanK; i < arr.length; i++){
			// acquiring element
			if(arr[i] <= k){
				countKsInWindow++;
			}
			
			// releasing element
			if(arr[i - countLessThanK] <= k){
				countKsInWindow--;
			}
			
			if(countKsInWindow > maxKsInWindow){
				maxKsInWindow = countKsInWindow;
			}
		}
		
		res = countLessThanK - maxKsInWindow;
		
		return res;
	}

}
