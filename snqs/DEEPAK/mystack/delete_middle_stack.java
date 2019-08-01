package mystack;
import java.util.*;
public class delete_middle_stack {
	 public Stack<Integer> DeleteMid(Stack<Integer>s,int sizeOfStack,int current)
	    {
	Stack<Integer> st=new Stack<>();
	int mid=sizeOfStack/2;
	for(int i=0;i<sizeOfStack;i++){
	    if(i==mid){
	        s.pop();
	        break;
	    }
	   st.push(s.pop());
	    
	}
	while(st.size()>0){
	    s.push(st.pop());
	}
	return s;
	    } 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
