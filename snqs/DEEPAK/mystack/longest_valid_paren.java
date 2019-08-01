package mystack;
import java.util.*;
public class longest_valid_paren {
	public static int longestparen(String s){
        int res=0;
    Stack<Integer> st = new Stack<>();
		    st.push(-1);
		    for(int i=0;i<s.length();i++){
		        if(s.charAt(i) == '('){
		            st.push((i));
		        }else{
		            st.pop();
		            if(!st.isEmpty()){
		                res =Math.max(res,i-st.peek());
		            }else{
		                st.push(i);
		            }
		        }
		    }
		    return res;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
String s="((()()";
System.out.println(longestparen(s));
	}

}
