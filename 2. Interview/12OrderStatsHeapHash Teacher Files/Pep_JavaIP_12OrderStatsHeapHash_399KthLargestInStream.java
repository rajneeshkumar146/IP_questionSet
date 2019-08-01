package OrderStatsHeapHash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
/**
 * Put k largest elements in priority queue, print the smallest of them 
 */
public class Pep_JavaIP_12OrderStatsHeapHash_399KthLargestInStream {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		int k = scn.nextInt();
		// min heap
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		// add k elements to queue
		for (int i = 0; i < k; i++) {
			pq.add(arr[i]);
			if (i < k - 1)
				System.out.print("_ ");
			else
				System.out.print(pq.peek()+" ");
		}
		/**
		 * At any instance queue contains k largest elements
		 * We print the smallest of them
		 */ 
		for (int i = k; i < arr.length; i++) {
			if (pq.peek() < arr[i]) {
				pq.remove();
				pq.add(arr[i]);
			}
			System.out.print(pq.peek()+" ");
		}

	}

}

/*Test cases:
	8
	10 20 11 70 50 40 100 5
	3
	_ _ 10 11 20 40 50 50
	
	8
	10 20 11 70 50 40 100 5
	4
	_ _ _ 10 11 20 40 40
	
	8
	10 20 11 70 50 40 100 5
	5
	_ _ _ _ 10 11 20 20
	
	Source: https://www.geeksforgeeks.org/kth-largest-element-in-a-stream/   
	
	
*/