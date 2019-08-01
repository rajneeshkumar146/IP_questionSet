package interview.arrays;

import java.util.Scanner;

public class Pep_JavaIP_1Arrays_17RearrangePositiveNegative {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		
		for(int i = 0; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
		
		solve(arr);
	}

	private static void solve(int[] arr) {
		int neg = partition(arr);
		int pos = 1;
		
		// last condition to cover the case when there are no positive numbers
		while(neg < arr.length && pos < neg){
			swap(arr, pos, neg);
			pos += 2;
			neg += 1;
		}
		
		for(int val: arr){
			System.out.print(val + " ");
		}
	}
	
	private static int partition(int[] arr){
		int i = -1;
		
		for(int j = 0; j <= arr.length - 1; j++){
			if(arr[j] >= 0){
				i++;
				swap(arr, i, j);
			}
		}
		
		return i + 1;
	}
	
	private static int quickSortPartition(int[] arr, int lo, int hi){
		int i = lo - 1;
		int pivot = arr[hi];
		
		// lo to i is for <= pivot
		// i + 1 to j - 1 is for > pivot
		// j to hi - 1 unknown
		// all indices inclusive in nature
		for(int j = lo; j <= hi - 1; j++){
			if(arr[j] <= pivot){
				i++;
				swap(arr, i, j);
			}
		}
		
		swap(arr, i + 1, hi); // lo to i is <=, i + 1 now becomes ==, i + 2 to hi is >
		return i + 1;
	}
	
	private static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
