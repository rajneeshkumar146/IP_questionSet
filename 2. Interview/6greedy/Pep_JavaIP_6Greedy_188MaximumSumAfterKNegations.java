package interview.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_6Greedy_188MaximumSumAfterKNegations {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();

		int res = solve(arr, k);
		System.out.println(res);
	}

	public static int solve(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int val : arr) {
			pq.add(val);
		}

		for (int i = 1; i <= k; i++) {
			int rem = pq.remove();
			pq.add(-rem);
		}

		int sum = 0;
		while (pq.size() > 0) {
			sum += pq.remove();
		}
		
		return sum;
	}

}
