package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class Pep_JavaIP_8StacksNQueues_249InfixToPostfix {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		String str = scn.next();

		System.out.println(inToPost(str));
	}

	public static String inToPost(String str) {
		String rv = "";

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			int val = (int) ch;
			// System.out.println(val);
			// If character is albhabet, add to result
			if (val >= 97 && val <= 122) {
				rv += ch;
			} else {
				int myPref = preference(ch);
				if (stack.isEmpty()) {
					stack.push(ch);
				} else {

					if (ch == '(') {
						stack.push(ch);

					} else if (ch == ')') {
						//Solve current bracket
						while (!stack.isEmpty() && stack.peek() != '(') {
							rv += stack.pop();
						}
						//pop the '('
						stack.pop();

					} else {
						while (true) {

							if (stack.isEmpty()) {
								stack.push(ch);
								break;
							}
							char stackTop = stack.peek();
							// get preference of top of stack
							int topPref = preference(stackTop);
							//If ch has higher precedence than tos push
							//ex: tos = +, char = *, then * must be evaluated first
							// so push to stack top
							if (topPref < myPref) {
								stack.push(ch);
								break;
							} else {
								//equal precedence also popped
								rv += stack.pop();

							}
						}
					}
				}

			}

			//System.out.println(ch + "," + stack + ", " + rv);
		}
		//pop remaining operators
		while (!stack.isEmpty()) {
			rv += stack.pop();
		}

		return rv;
	}

	public static int preference(char ch) {

		if (ch == '+' || ch == '-') {
			return 1;
		} else if (ch == '*' || ch == '/') {
			return 2;
		} else if (ch == '^') {
			return 3;
		}
		//for handling '(' and ')'
		return 0;
	}

}

/*Test Cases: 
a+b*(c^d-e)^(f+g*h)-i
---------------------------
abcd^e-fgh*+^*+i-


a+b*(c^d-e)^(f+g+h)-i*f
---------------------------
abcd^e-fg+h+^*+if*-


a+b*(c*d-e)^(f+g*h)-i
---------------------------
abcd*e-fgh*+^*+i-

Source: https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/

*/


