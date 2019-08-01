package mystack;
import java.util.*;
public class print_brakt_no {
	 public static void printbrano(String s){
		 Stack<Integer> st=new Stack<>();
		 char[] ch=s.toCharArray();
         int u=0;
         for(int i=0;i<ch.length;i++){
             if(ch[i]=='('){
                 ++u;
                 System.out.print(u + " ");
                 st.push(u);
             }
             if(ch[i]==')'){
                 System.out.print(st.pop() + " "); 
             }
         }
         System.out.println(); 
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ss="(((())";
		String s="(0+1)*0(0+1)*0(0+1)*";
		printbrano((s));

	}

}
