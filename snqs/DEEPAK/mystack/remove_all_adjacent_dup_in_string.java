package mystack;
import java.util.*;
public class remove_all_adjacent_dup_in_string {
public static void removeadjdup(String s){
	StringBuilder sb=new StringBuilder();

	Stack<Character> st=new Stack<>();
	for(int i=0;i<s.length();i++){
		char ch=s.charAt(i);
		if(!st.isEmpty() && st.peek()==ch)
			st.pop();
		else
			st.push(ch);
	}
	while(!st.isEmpty()){
		sb.append(st.pop());
	}
	System.out.println(sb.reverse());
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
String s="abbaca";
removeadjdup(s);
	}

}
