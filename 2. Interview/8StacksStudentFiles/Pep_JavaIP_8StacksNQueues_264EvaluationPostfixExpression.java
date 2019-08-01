--------------------------------------------------------------------------------
Description
--------------------------------------------------------------------------------
1. You are given a string, which represents a postfix expression.
2. You have to evaluate it and print the result.
For eg : for given postfix expression ->  231*+9-
         the result will be : -4.
--------------------------------------------------------------------------------
--------------------------------------------------------------------------------
package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class Pep_JavaIP_8StacksNQueues_264EvaluationPostfixExpression {

	 static int evaluatePostfix(String exp)
	    {
	       
	    }

	    // Driver program to test above functions
	    public static void main(String[] args)
	    {
	    	Scanner scn = new Scanner(System.in);
			String str = scn.next();
	        System.out.println(evaluatePostfix(str));
	    }
}
/*
Test cases:
231*+9-
----------------------
-4

231*+9-231*+*
----------------------
-20

231*+9-231*+*9+
----------------------
-11

Source: https://www.geeksforgeeks.org/stack-set-4-evaluation-postfix-expression/
*/
