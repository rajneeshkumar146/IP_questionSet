package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class Pep_JavaIP_8StacksNQueues_264EvaluationPostfixExpression {

	 static int evaluatePostfix(String exp)
	    {
	        //create a stack
	        Stack<Integer> stack=new Stack<>();
	         
	        // Scan all characters one by one
	        for(int i=0;i<exp.length();i++)
	        {
	            char c=exp.charAt(i);
	             
	            // If the scanned character is an operand (number here),
	            // push it to the stack.
	            if(Character.isDigit(c))
	            	stack.push(c - '0');
	             
	            //  If the scanned character is an operator, pop two
	            // elements from stack apply the operator
	            else
	            {
	                int val1 = stack.pop();
	                int val2 = stack.pop();
	                 
	                switch(c)
	                {
	                    case '+':
	                    stack.push(val2+val1);
	                    break;
	                     
	                    case '-':
	                    stack.push(val2- val1);
	                    break;
	                     
	                    case '/':
	                    stack.push(val2/val1);
	                    break;
	                     
	                    case '*':
	                    stack.push(val2*val1);
	                    break;
	              }
	            }
	        }
	        return stack.pop();    
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