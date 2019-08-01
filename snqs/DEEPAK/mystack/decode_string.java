package mystack;
import java.util.*;
public class decode_string {
	 public static String decode(String s) {
	        if (s.length() == 0 || s == null) {
	            return s;
	        }
	        Stack<String> strStack = new Stack<String>();
	        Stack<Integer> numStack = new Stack<Integer>();
	        StringBuilder res = new StringBuilder();
	        int idx = 0;
	        while (idx < s.length()) {
	            if (Character.isDigit(s.charAt(idx))) {
	                int n = 0;
	                while (Character.isDigit(s.charAt(idx))) {
	                    n = n * 10 + (s.charAt(idx) - '0');
	                    idx++;
	                }
	                numStack.push(n);
	            } else if (s.charAt(idx) == '[') {
	                strStack.push(res.toString());
	                res = new StringBuilder("");
	                idx++;
	            } else if (s.charAt(idx) == ']') {
	                StringBuilder temp = new
	                              StringBuilder(strStack.pop());
	                int t = numStack.pop();
	                for (int i = 0; i < t; i++) {
	                    temp.append(res);
	                }
	                res = temp;
	                idx++;
	            } else {
	                res.append(s.charAt(idx++));
	            }
	        }
	        return res.toString();
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
String s="3[a]2[bc]";
System.out.println(decode(s));
	}

}
