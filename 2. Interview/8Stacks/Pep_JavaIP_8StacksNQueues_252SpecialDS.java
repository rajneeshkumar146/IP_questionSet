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

			if (st.isEmpty()) {
				st.push(val);
				min.push(val);
				return;
			}

			int minTop = min.peek();
			st.push(val);

			if (minTop > val) {
				min.push(val);
			} else {
				min.push(minTop);
			}

		}

		public int pop() {
			if (st.isEmpty()) {
				System.out.println("stack is empty");
				return -1;
			}

			int rv = st.pop();
			min.pop();

			return rv;
		}

		public int getMin() {
			return min.peek();
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
