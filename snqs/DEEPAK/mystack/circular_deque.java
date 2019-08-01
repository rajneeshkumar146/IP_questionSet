package mystack;
import java.util.*;
public class circular_deque {
	 public static LinkedList<Integer> cdeque;
	    public static int size;
	    public circular_deque(int k) {
	        cdeque=new LinkedList<Integer>();
	        size=k;
	    }
	    
	    public static boolean insertFront(int value) {
	        if(cdeque.size()<

	        		){
	            cdeque.addFirst(value);
	            return true;
	        }
	        return false;
	    }
	    
	    public static boolean insertLast(int value) {
	        if(cdeque.size()<size){
	            cdeque.addLast(value);
	            return true;
	        }
	        return false;
	    }
	    
	    public static boolean deleteFront() {
	        if(cdeque.size()>0){
	            cdeque.removeFirst();
	            return true;
	        }
	        return false;
	    }
	    
	    public static boolean deleteLast() {
	        if(cdeque.size()>0){
	            cdeque.removeLast();
	            return true;
	        }
	        return false;
	    }
	    
	    public static int getFront() {
	        if(cdeque.size()>0){
	            return cdeque.getFirst();
	        }
	        return -1;
	    }
	    
	    public static int getRear() {
	        if(cdeque.size()>0){
	            return cdeque.getLast();
	        }
	        return -1;
	    }
	    
	    public static  boolean isEmpty() {
	        if(cdeque.size()==0)
	            return true;
	        else 
	            return false;
	    }
	    
	    public static boolean isFull() {
	        if(cdeque.size()==size)
	            return true;
	        return false;
	    }
	
	public static void main(String[] args) {

		circular_deque c=new circular_deque(5);
		insertFront(1);
		insertFront(2);
		insertFront(3);
		insertLast(10);
		insertFront(5);
		System.out.println(getFront());
		System.out.println(getRear());
		System.out.println(deleteLast());
		System.out.println(getRear());
	}

}
