package interview.arrays;

import java.util.Scanner;

public class Pep_JavaIP_1Arrays_10StockBuySell {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		
		solve(arr);
	}

	private static void solve(int[] arr) {
		int sum = 0;
		
		int boughtOn = 0;
		int soldOn = 0;
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] >= arr[i - 1]) {
				soldOn++;
			} else {
				if(boughtOn != soldOn) {
					System.out.println(boughtOn + " " + soldOn);
				}
				
				sum += arr[soldOn] - arr[boughtOn];
				boughtOn = i;
				soldOn = i;
			}
		}
		
		if(boughtOn != soldOn) {
			System.out.println(boughtOn + " " + soldOn);
		}
		
		sum += arr[soldOn] - arr[boughtOn];
		System.out.println(sum);
	}

}
