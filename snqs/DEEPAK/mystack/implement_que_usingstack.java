package mystack;
import java.util.*;
public class implement_que_usingstack {
	Stack<Integer> s1;
    Stack<Integer> s2;
      implement_que_usingstack() {
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        
    }
    
    public void push(int x) {
                s1.push(x);

    }
    
    public  int pop() {
        if (s2.isEmpty()) {
        while (!s1.isEmpty())
            s2.push(s1.pop());
    }
   int n= s2.pop(); 
   return n;
    }
    
    public int peek() {
        if(!s2.isEmpty()){
            return s2.peek();
        }
        else{
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return s2.peek();
        }
    }
    
    public boolean empty() {
           return s1.isEmpty() && s2.isEmpty();
 
    }


	public static void main(String[] args) {

	}

}
