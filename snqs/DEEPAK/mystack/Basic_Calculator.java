package mystack;
import java.util.*;
public class Basic_Calculator {
	public static int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int res = 0;
        int sign = 1;
        int num = 0;
        
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '+') {
                res += sign * num;
                sign = 1;
                num = 0;
            } else if (ch == '-') {
                res += sign * num;
                sign = -1;
                num = 0;
            } else if (ch == '(') {
                st.push(res);
                st.push(sign);
                res = 0;
                sign = 1;
            } else if (ch == ')') {
                res += sign * num;
                num = res;
                sign = st.pop();
                res = st.pop();
            }
        }
        
        res += sign * num;
        return res;
    }
	public static void main(String[] args) {
		String s="2-1+(1+2)-2";
		
		System.out.println(calculate(s));

	}

}
