package mystack;
import java.util.*;
public class min_add_to_make_parent_balance {
	 public int minAddToMakeValid(String S) {
	        Stack<Character> st=new Stack<>();
	        for(int i=0;i<S.length();i++){
	            char ch=S.charAt(i);
	            if(st.isEmpty())
	                st.push(ch);
	           else if(ch==')' && !st.isEmpty() && st.peek()=='(')
	                st.pop();
	            else
	                st.push(ch);
	        }
	        return st.size();
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
