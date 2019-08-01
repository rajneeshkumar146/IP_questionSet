package mystack;
import java.util.*;
public class postfix_exprsn {
	 public static int solvepostfix(String s){
	        Stack<Integer> stack=new Stack<>();
	       for(int i=0;i<s.length();i++)
			    {
			        char c=s.charAt(i);
			        if(c>='0'&&c<='9')
			        stack.push(c-'0');
			        else 
			        {
			            int p=stack.pop();
			            int q=stack.pop();
			            if(c=='*')
			            stack.push(p*q);
			            else if(c=='/')
			            stack.push(q/p);
			            else if(c=='+')
			            stack.push(q+p);
			            else 
			            stack.push(q-p);
			        }
			    }
	    
	    return stack.pop();
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solvepostfix("43+2*"));

	}

}
