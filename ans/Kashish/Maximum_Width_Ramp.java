package InternQuestAS1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Maximum_Width_Ramp {
	public int maxWidthRamp(int[] a) {

		 int N = a.length;
	        Stack<Integer> s = new Stack();
	        for (int i = 0; i < N; i++) {
	            if (s.isEmpty() || a[i] < a[s.peek()]) {
	                s.push(i);
	            }
	        }
	       
	        int res = 0;
	        for (int i = N - 1; i >= 0; i--) {
	            while (!s.isEmpty() && a[s.peek()] <= a[i]) {
	                res = Math.max(res, i - s.pop());
	            }      
	        }
	        return res;
	 

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
	}

}
