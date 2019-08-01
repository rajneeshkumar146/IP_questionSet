package SnQs;

import java.util.Stack;

public class ternar_expression_parser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(parseTernary("F?1:T?4:5"));
	}

	public static String parseTernary(String expression) {

		if (expression == null || expression.length() == 0) {
			return "";
		}

		Stack<Character> st = new Stack<>();

		for (int i = expression.length() - 1; i >= 0; i--) {

			char ch = expression.charAt(i);
			if (st.size() > 0 && st.peek() == '?') {
				st.pop();// ?

				char val1 = st.pop();
				st.pop();// :
				char val2 = st.pop();

				if (ch == 'T') {
					st.push(val1);
				} else {
					st.push(val2);
				}
			} else {
				st.push(ch);
			}
		}

		String res = "" + st.pop();
		return res;
	}

}
