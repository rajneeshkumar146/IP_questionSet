package SearchingSorting;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_2SnS_63MedianofStreamofIntegers {
/* What : Given a stream of integer, find their median. Online Algorithm
*How : Maintain two priority queques, min and max. Keep adding elements.
*			If difference in size becomes 2, remove from larger queue.
*			Median is given by top element of larger queue.
*
* Why :
* Compare to brute-force method, we will add elements uptill now to an array
* sort the array, and then return median which is largest of small elements
* or smallest of large elements.
* seMaxPQ(max heap)---> stores all small elements
* leMinPQ(min heap)---> stores all larger elements
*	At any instant, even sized array has equal elements, odd sized has 1 extra.
* These queques mimic the state of array of merged.
*
*/
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int first = scn.nextInt();
		add(first);
		System.out.println("Median is: " + first);
		char ch = scn.next().charAt(0);
		while (ch == 'Y' || ch == 'y') {
			int input = scn.nextInt();
			add(input);
			System.out.println("Median is: " + peek());
			ch = scn.next().charAt(0);
		}
	}
	/*This stores all the larger elements i.e right half of array*/
	private static PriorityQueue<Integer> leMinPQ = new PriorityQueue<>();
	/*This stores all the smaller elements i.e leftt half of array*/
	private static PriorityQueue<Integer> seMaxPQ = new PriorityQueue<>(Collections.reverseOrder());
	private static int size;

	// logn
	public static void add(int num) {
		if (seMaxPQ.size() > 0 && num < seMaxPQ.peek()) {
			seMaxPQ.add(num);
		} else if (leMinPQ.size() > 0 && num > leMinPQ.peek()) {
			leMinPQ.add(num);
		} else {
			seMaxPQ.add(num);
		}

		/*Since first half of array and second half of array must contain
		* equal no of elements or differ by one element
		*/
		if (seMaxPQ.size() - leMinPQ.size() == 2) {
			leMinPQ.add(seMaxPQ.remove());
		} else if (leMinPQ.size() - seMaxPQ.size() == 2) {
			seMaxPQ.add(leMinPQ.remove());
		}

		size++;
	}

	// logn
	/*remove from queue of larger size*/
	public static int remove() {
		if (size == 0) {
			return -1;
		}

		size--;
		if (leMinPQ.size() > seMaxPQ.size()) {
			return leMinPQ.remove();
		} else {
			return seMaxPQ.remove();
		}
	}

	// o1
	public static int peek() {
		if (size == 0) {
			return -1;
		}

		if (leMinPQ.size() > seMaxPQ.size()) {
			return leMinPQ.peek();
		} else {
			return seMaxPQ.peek();
		}
	}

}
/*
Test cases:
15 y 5 y 1 y 3 n
-----------------
Median is: 15
Median is: 5
Median is: 5
Median is: 3


15 y 5 y 1 y 3 y 15 y 5 y 1 y 3 n
------------------------------
Median is: 15
Median is: 5
Median is: 5
Median is: 3
Median is: 5
Median is: 5
Median is: 5
Median is: 3

15 y 5 y 1 y 3 y 15 y 5 y 1 y 3 y 15 y 5 y 1 y 3 y 15 y 5 y 1 y 3 n
-------------------------
Median is: 15
Median is: 5
Median is: 5
Median is: 3
Median is: 5
Median is: 5
Median is: 5
Median is: 3
Median is: 5
Median is: 5
Median is: 5
Median is: 3
Median is: 5
Median is: 5
Median is: 5
Median is: 3

Source: https://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/


*/
