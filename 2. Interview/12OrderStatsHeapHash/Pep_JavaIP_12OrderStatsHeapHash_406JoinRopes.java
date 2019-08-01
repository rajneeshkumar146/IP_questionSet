package OrderStatsHeapHash;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_12OrderStatsHeapHash_406JoinRopes {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		//Similar to Huffman encoder
		//Remove 2, Merge them, Put them back.
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
			pq.add(arr[i]);
		}
		int cost = 0;
		while (pq.size() != 1) {
			int one = pq.remove();
			int two = pq.remove();
			cost += one + two;
			pq.add(one + two);
		}

		System.out.println(cost);

	}
}
/*
 Test Cases: 4 
  4 3 2 6
  -------------- 
  29
 
 5
 1 6 10 4 3
 ----------
 50
 
 8
 1 4 5 10 11 12 12 14
 ------------------- 
 196
 
 Source: https://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/
 
 
 */