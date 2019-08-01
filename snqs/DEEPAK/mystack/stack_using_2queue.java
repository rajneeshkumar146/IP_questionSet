package mystack;
import java.util.*;
public class stack_using_2queue {
	static Queue<Integer> q1 = new LinkedList<Integer>();
    static Queue<Integer> q2 = new LinkedList<Integer>();
    
    static int pop()
    {
	if(q1.size()==0)return -1;
	while(q1.size()>1){
	    q2.add(q1.remove());
	}
	int ans=q1.remove();
	q1=q2;
	q2=new LinkedList();
	return ans;
    }
	
    static void push(int a)
    {
	q1.add(a);
    }
    
    public static void main(String[] args){
       push(3);
       push(5);
       push(6);
       push(9);
       System.out.println(pop());

       System.out.println(pop());
       
    }
}
