package Stacks;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_8StacksNQueues_256LRUImplementation {
/**
 * Time complexity : (Total pages - noOfPageFaults)*k
 * 
 */
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int pageframes = scn.nextInt();
		
		LinkedList<Integer> Q = new LinkedList<>();
		HashSet<Integer> set = new HashSet<>();

		for (int i = 0; i < pageframes; i++) {
			Q.addLast(arr[i]);
			set.add(arr[i]);
		}
		
		int noofPagefaults = pageframes;
		
		for (int i = pageframes; i < arr.length; i++) {
			
			if (set.contains(arr[i]) == false) {
				int rp = Q.removeFirst();
				set.remove(rp);
				Q.addLast(arr[i]);
				set.add(arr[i]);
				noofPagefaults++;
			} else {
				// we make that element most recently used element
				// this is done by removing it from its position and adding it at the end.
				//loop though linkedlist and remove it
				Integer ele=arr[i];
				boolean answer=Q.remove(ele);
				Q.addLast(arr[i]);
			}
		}
		
		System.out.println(noofPagefaults);

	}

}

/*Test Cases: 
12
1 2 3 4 1 2 5 1 2 3 4 5
3
---------------
10

15
1 2 3 4 1 2 5 1 2 3 4 5 4 3 5
3
------------------
10


16
1 2 3 4 1 2 5 1 2 3 4 5 4 3 5 4
3
--------------------
10


Source: https://www.geeksforgeeks.org/lru-cache-implementation/

*/

