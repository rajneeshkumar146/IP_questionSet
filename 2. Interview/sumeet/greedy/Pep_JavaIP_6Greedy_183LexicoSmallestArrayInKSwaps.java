package interview.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Pep_JavaIP_6Greedy_183LexicoSmallestArrayInKSwaps {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for(int i = 0; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		
		solve(arr, k);
		display(arr);
	}
	
	public static void solve(int[] arr, int k){
		int count = 0;
		
		// Try to get the best candidate for left-most spot first
		// second left-most sport then and so on..
		while(k > 0 && count < arr.length){
			int mini = count;
			// Find the smallest element till k
			for(int i = count + 1; i <= count + k && i < arr.length; i++){
				if(arr[i] < arr[mini]){
					mini = i;
				}
			}
			
			// bubble it up to the left-most spot of unsolved area
			// Use k's for bubbling up
			int temp = arr[mini];
			for(int i = mini; i > count; i--){
				arr[i] = arr[i - 1];
				k--;
			}
			arr[count] = temp;
			count++;
		}
	}
	
	private static void display(int[] arr){
		for(int val: arr){
			System.out.print(val + " ");
		}
		System.out.println(".");
	}
}
