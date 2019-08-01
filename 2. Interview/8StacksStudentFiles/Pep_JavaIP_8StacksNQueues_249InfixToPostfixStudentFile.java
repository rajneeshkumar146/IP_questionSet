--------------------------------------------------------------------------------
Description
--------------------------------------------------------------------------------
1. You are given a string, which represents an infix expression.
2. You have to convert infix expression to postfix expression using stack.
For eg : infix expression -> a + b * c
postfix expression will be -> abc*+
--------------------------------------------------------------------------------
--------------------------------------------------------------------------------
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

   //code

	}

	public static int preference(char ch) {

		if (ch == '+' || ch == '-') {
			return 1;
		} else if (ch == '*' || ch == '/') {
			return 2;
		} else if (ch == '^') {
			return 3;
		}

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
