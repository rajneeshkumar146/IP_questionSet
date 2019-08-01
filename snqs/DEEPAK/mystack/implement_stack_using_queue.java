package mystack;
import java.util.*;
public class implement_stack_using_queue {
	static Queue<Integer> q1 = new LinkedList<>();
	static Queue<Integer> q2 = new LinkedList<>();
	static int top;
	 
	    
	    public static void push(int x) {
	        q1.add(x);
	        top=x;
	    }
	    
	    public static  int pop() {
	         while (q1.size() > 1) {
	        top = q1.remove();
	        q2.add(top);
	    }
	  int d=  q1.remove();
	    Queue<Integer> temp = q1;
	    q1 = q2;
	    q2 = temp;
	        return d;
	    }

	    
	    public static int top() {
	        return top;
	    }
	    
	    public static boolean empty() {
	        return q1.isEmpty();
	    }
	

	public static void main(String[] args) {
push(3);
push(4);
push(5);
push(6);
push(7);
System.out.println(pop());
System.out.println(pop());
System.out.println(top());

	}

}
