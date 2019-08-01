package mystack;
import java.util.*;
public class queue_using_2_stack {
	static Stack<Integer> s1 = new Stack<Integer>();
	    static Stack<Integer> s2 = new Stack<Integer>();
	   public static void insert(int B)
	   {
	        s1.push(B);
	    }
	   public static int remove()
	    {
	        if(s1.size()==0 && s2.size()==0)
	        return -1;
	        if(!s2.isEmpty()){
	            return s2.pop();
	        }else{
	            while(!s1.isEmpty()){
	                s2.add(s1.pop());
	            }
	            return s2.pop();
	        }
	    }
	public static void main(String[] args) {
insert(2);
insert(3);
insert(4);
insert(5);
System.out.println(remove());
insert(6);
System.out.println(remove());
System.out.println(remove());


	}

}









