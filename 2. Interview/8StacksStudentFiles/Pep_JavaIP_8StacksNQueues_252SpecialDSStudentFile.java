--------------------------------------------------------------------------------
Description
--------------------------------------------------------------------------------
Design a Data Structure that supports following operations in 0(1):
a. push() which adds an element.
b. pop() which removes an element.
c. getMin() which returns minimum of all elements present.
--------------------------------------------------------------------------------
--------------------------------------------------------------------------------
package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class Pep_JavaIP_8StacksNQueues_252SpecialDS {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		GetMinSpecialStack st = new GetMinSpecialStack();

		do {
			int choice = scn.nextInt();
			switch (choice) {
			case 1:
				st.push(scn.nextInt());
				break;
			case 2:
				System.out.println(st.pop());
				break;
			case 3:
				System.out.println(st.getMin());
				break;
			default:
				return;
			}
		} while (true);


	}

	static class GetMinSpecialStack {

		Stack<Integer> st = new Stack<>();
		Stack<Integer> min = new Stack<>();
//----------------------------------------------------
//Only these functions have to be written to solve this question.
		public void push(int val) {

		}

		public int pop() {

		}

		public int getMin() {

		}
	}
//-------------------------------------------------------------
}

/*Test Cases:
1 2
1 4
1 6
1 8
3
1 15
1 -1
3
4
---------------
2
-1

1 2
1 4
1 6
1 8
1 6
1 8
1 10
3
1 -8
3
7
------------------
2
-8


1 2
1 4
1 6
1 8
1 6
1 4
1 2
3
1 0
3
1 -2
3
2
3
4
--------------------
2
0
-2
-2
0



Source: https://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/

*/
