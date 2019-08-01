package mystack;

import java.util.*;

public class infix_to_postfix {
	public static boolean isoper(char c) {
		if (c == '/' || c == '*' || c == '+' || c == '-' || c == '^')
			return true;
		return false;
	}

	public static int getpriority(char c) {
		if (c == '^')
			return 4;
		if (c == '/' || c == '*')
			return 3;
		if (c == '+' || c == '-')
			return 2;
		return -1;
	}

	public static void inftopostfix(String s) {
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if(isoper(s.charAt(i)))
	        {
	            //System.out.print(s.charAt(i));
	            if(st.isEmpty())
	            st.push(s.charAt(i));
	            else if(st.peek()=='(')
	                st.push(s.charAt(i));
	            else if(getpriority(st.peek())<getpriority(s.charAt(i)))
	            st.push(s.charAt(i));
	            else if(getpriority(st.peek())>=getpriority(s.charAt(i)))
	            {
	                while(!st.isEmpty()&&isoper(st.peek())&&
	                getpriority(st.peek())>=getpriority(s.charAt(i)))
	                System.out.print(st.pop());
	                st.push(s.charAt(i));
	            }
	        }
	        else if(s.charAt(i)>='A'&&s.charAt(i)<='z')
	        System.out.print(s.charAt(i));
	        else if(s.charAt(i)=='(')
	        st.push(s.charAt(i));
	        else if(s.charAt(i)==')')
	        {
	            while(!st.isEmpty()&&st.peek()!='(')
	            System.out.print(st.pop());
	            if(!st.isEmpty())
	            st.pop();
	        }
	    }
	  
		while (!st.isEmpty()) {
			System.out.print(st.pop());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "A*(B+C)/Z";
		inftopostfix(s);
	}

}
