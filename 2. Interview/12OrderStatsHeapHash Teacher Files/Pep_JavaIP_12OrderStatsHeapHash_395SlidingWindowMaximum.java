package OrderStatsHeapHash;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_12OrderStatsHeapHash_395SlidingWindowMaximum {
//Use priority queue(max heap) to store k elements of window
//Build first window explicity.Peek max and print.
//Iterate over array, in k sized windows. Remove first element of previous window
// add last element of current window.
//Peek max of current window and print
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		int k = scn.nextInt();
		//Max-Heap , to get max element of each window
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		//Build the first window explicitly
		for (int i = 0; i < k; i++) {
			pq.add(arr[i]);
			if (i != k - 1)
				System.out.print("_ ");
		}
		//print max of first window
		System.out.print(pq.peek() + " ");
		int lo = 0;
		int hi = k - 1;
		//traverse over all windows
		while (hi < arr.length - 1) {
			//remove first element of previous window
			pq.remove(arr[lo]);
			lo++;
			hi++;
			// add last element of current window
			pq.add(arr[hi]);
			//print max of current window
			System.out.print(pq.peek() + " ");
		}

	}

}
/*
 * Test cases:
 * 
 * 9 
 * 1 2 3 1 4 5 2 3 6 3
 * 
 * _ _ 3 3 4 5 5 5 6
 * 
 * 9
 * 1 2 3 31 4 5 255 3 326 3 
 * 
 * _ _ 3 31 31 31 255 255 326
 * 
 * 5 
 * 1 1 -1 0 1 2 
 * 
 * _ 1 1 0 1
 * 
 * Source :
 * https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays
 * -of-size-k/
 * 
 * 
 */