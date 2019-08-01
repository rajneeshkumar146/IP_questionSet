package mystack;
import java.util.*;
public class min_str_reversal {
	public static int min_str_reversal(String s){
		Stack<Character> st=new Stack<>();
		if(s.length()%2!=0)
			return -1;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='{'){
				st.push(s.charAt(i));
			}else{
				if(st.size()>0 && s.charAt(i)=='}' && st.peek()=='{'){
					st.pop();
				}else{
					st.push(s.charAt(i));
				}
			}
		}
		int opbrackets=0;
		int clbrackets=0;
		while(st.size()>0){
			if(st.peek()=='{'){
				opbrackets++;
				st.pop();
				
			}else{
				clbrackets++;
				st.pop();
			}
		}
		double op=Math.ceil((opbrackets*1.0)/2.0);
		double cl=Math.ceil((clbrackets*1.0)/2.0);
		return (int)(op+cl);

		
	}
public static void main(String[] args){
	String s="}}}}}}{}{}}}{{}}}}{}}{{{}{}{}{}}{{{{}}}{}}";
	System.out.println(min_str_reversal(s));
	
}
}
