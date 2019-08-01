package interview.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Pep_JavaIP_6Greedy_181MaximizeSumConsecutiveDifferences {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		int res = solve(arr);
		System.out.println(res);
	}

	// sort and find difference between elements of smaller half
	// and larger half. Twice of sum of those differences is the answer.
	// Greediness - Pairing each min with available max.
	public static int solve(int[] arr) {
		Arrays.sort(arr);
		int res = 0;

		int left = 0;
		int right = arr.length - 1;
		while(left < right){
			res -= 2 * arr[left];
			res += 2 * arr[right];
			
			left++;
			right--;
		}
		
		return res;
	}

}
