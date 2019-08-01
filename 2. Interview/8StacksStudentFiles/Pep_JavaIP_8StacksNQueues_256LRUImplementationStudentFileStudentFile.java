--------------------------------------------------------------------------------
Description
--------------------------------------------------------------------------------
Implement Least Recently Used(LRU) cache algorithm.
For explanantion -> follow this link
https://en.wikipedia.org/wiki/Cache_replacement_policies#Least_recently_used_(LRU)
--------------------------------------------------------------------------------
--------------------------------------------------------------------------------
package Stacks;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_8StacksNQueues_256LRUImplementation {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int pageframes = scn.nextInt();
	

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
