package interview.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_227LengthOfLongestValidExpression {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		
		System.out.println(solve(str));
	}
	
	private static int solve(String str){
		int len = Integer.MIN_VALUE;
		
		LinkedList<Integer> stack = new LinkedList<>();
		stack.addFirst(-1);
		
		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			
			if(ch == '('){
				stack.addFirst(i);
			} else if(ch == ')'){
				stack.removeFirst();
				
				if(stack.size() > 0){
					len = Math.max(len, i - stack.getFirst());
				} else {
					stack.addFirst(i);
				}
			}
		}
		
		return len;
	}

}

// https://www.geeksforgeeks.org/length-of-the-longest-valid-substring/
/* Test case 1 
((()
2
*/

/* Test case 2 
)()())
4
*/

/* Test case 3 
()(()))))
6
*/