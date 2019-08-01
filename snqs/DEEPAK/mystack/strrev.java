package mystack;
import java.util.*;
public class strrev {

	public static void strrev(String s){
		
		Stack<Character> st=new Stack<>();
		for(int i=0;i<s.length();i++){
			st.push(s.charAt(i));
		}
		while(st.size()!=0){
			System.out.println(st.pop());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
String s="pepcode";
strrev(s);
	}

}
