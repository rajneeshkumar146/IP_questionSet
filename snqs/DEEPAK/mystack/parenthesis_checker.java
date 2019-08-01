package mystack;
import java.util.*;
public class parenthesis_checker {
	 public static boolean ismatched(char a,char b){
	        if(a=='{' && b=='}' || a=='[' && b==']' || a=='(' && b==')')
	        return true;
	        return false;
	    }
	    public static boolean isbal(String s){
	        Stack<Character> st=new Stack<>();
	        for(int i=0;i<s.length();i++){
	            char c=s.charAt(i);
	            if(c=='{' || c=='[' || c=='('  )
	            st.push(c);
	            else{
	                if(st.size()==0)
	                return false;
	                boolean mat=ismatched(st.peek(),c);
	                if(mat==false)
	                return false;
	                else{
	             
	                st.pop();
	            }
	            }
	        }
	        if(st.size()==0)
	        return true;
	        return false;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
