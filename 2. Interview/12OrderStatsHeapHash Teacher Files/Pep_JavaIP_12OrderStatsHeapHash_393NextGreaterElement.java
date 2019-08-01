package OrderStatsHeapHash;

import java.util.Scanner;
import java.util.Stack;

public class Pep_JavaIP_12OrderStatsHeapHash_393NextGreaterElement {
//If we find a next = arr[i] which is greater than top of stack
// we print the pair, and try to settle as many elements in stack as possible from
//next.
//Is next < top of stack, we push the element back.
// where element = top of stack
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		printNGE(arr, arr.length);

	}

	static void printNGE(int arr[], int n) {
		int i = 0;
		Stack s = new Stack();
		int element, next;

		/* push the first element to stack */
		s.push(arr[0]);

		// iterate for rest of the elements
		for (i = 1; i < n; i++) {
			next = arr[i];

			if (s.isEmpty() == false) {

				// if stack is not empty, then
				// pop an element from stack
				element = (int) s.pop();

				/*
				 * If the popped element is smaller than next, then a) print the pair b) keep
				 * popping while elements are smaller and stack is not empty
				 */
				while (element < next) {
					System.out.println(element + " --> " + next);
					if (s.isEmpty() == true)
						break;
					element = (int) s.pop();
				}

				/*
				 * If element is greater than next, then push the element back
				 */
				if (element > next)
					s.push(element);
			}

			/*
			 * push next to stack so that we can find next greater for it
			 */
			s.push(next);
		}

		/*
		 * After iterating over the loop, the remaining elements in stack do not have
		 * the next greater element, so print -1 for them
		 */
		while (s.isEmpty() == false) {
			element = (int) s.pop();
			next = -1;
			System.out.println(element + " -- " + next);
		}
	}

}

/*
5 11 1 2 3 4
1 --> 2
2 --> 3
3 --> 4
4 -- -1
11 -- -1

4 11 12 3 4
11 --> 12
3 --> 4
4 -- -1
12 -- -1

5
12 13 31 21 14
12 --> 13
13 --> 31
14 -- -1
21 -- -1
31 -- -1

Source : https://www.geeksforgeeks.org/next-greater-element/

*/