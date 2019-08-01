package mystack;
import java.util.*;

import javax.sound.sampled.ReverbType;
public class queue_reversals {
    public static  Queue<Integer> rev(Queue<Integer> q){
    Stack<Integer> st=new Stack<>();
    while(!q.isEmpty()){
        st.push(q.remove());
    }
    while(!st.isEmpty()){
     q.add(st.pop());   
    }
    return q;
    }
   
	public static void main(String[] args) {
Queue<Integer> q=new LinkedList<>();
q.add(3);
q.add(4);
q.add(5);
q.add(6);
q.add(7);
System.out.println(q.peek());
rev(q);
System.out.println(q.peek());
	}

}
