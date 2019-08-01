-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
                                       Question Description
-----------------------------------------------------------------------------------------
1. You are given a stream of integers.
2. You have to calculate median of running stream of integers.
	 Median for even length of stream is defined as smaller of the middle two elements, if the stream is sorted.
	 Median for odd length of stream is defined as the middle element, if the stream is sorted.
   For eg : The stream is 15 5 1 3, its median is to be calculated after each addition of integer.
	 Median after addition of 15 : 15, as the stream formed so far is 15
	 Median after addition of 5 : 5, as stream so far is 15 5
	 Median after addition of 1 : 5, as stream so far is 15 5 1
	 Median after addition of 3 : 3, as stream so far is 15 5 1 3
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
package SearchingSorting;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_2SnS_63MedianofStreamofIntegers {

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

	private static PriorityQueue<Integer> leMinPQ = new PriorityQueue<>();
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

		if (seMaxPQ.size() - leMinPQ.size() == 2) {
			leMinPQ.add(seMaxPQ.remove());
		} else if (leMinPQ.size() - seMaxPQ.size() == 2) {
			seMaxPQ.add(leMinPQ.remove());
		}

		size++;
	}

	// logn
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
