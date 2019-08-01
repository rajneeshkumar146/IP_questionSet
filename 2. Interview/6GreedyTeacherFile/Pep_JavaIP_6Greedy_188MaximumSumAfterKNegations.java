package interview.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
/*Given an array of size n and a number k.Modify array K number of times.
* In each operation we can replace any array element arr[i] by -arr[i]. 
* perform this operation in such a way that after K operations, sum of array must be maximum 
*O(n + kLogn)
*/
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
	/*Greedy choice remove min element and negate it
	* it leaves larger numbers which contribute positiove sum
	 */
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
/*
Test cases:

*************************************************
test case 1
*************************************************
5 4
-2 0 5 -1 2
-----------------
10

*************************************************
test case 2
*************************************************
4 3
9 8 8 5 
--------------
20

*************************************************
test case 3
*************************************************
4 3
-10 0 0 0
------------------
10
/*Source: https://www.geeksforgeeks.org/maximize-array-sum-k-negations-set-2/ */