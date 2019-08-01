package mystack;
import java.util.*;
public class lru_cache {
	 static Deque<Integer> dq;
	    static HashMap<Integer,Integer> hm; 
	    static int size=0;
	    public lru_cache(int N) {
	        dq=new LinkedList<>();
	        hm=new HashMap<>();
	        size=N;
	    }
	    
	    public int get(int x) {
	        if(!hm.containsKey(x)){
	            return -1;
	        }else{
	           dq.remove(x);
	           dq.addFirst(x);
	           return hm.get(x);
	        }
	    }
	    
	    public void set(int x, int y) {
	        if(!hm.containsKey(x)){
	            if(dq.size()>=size){
	               int peek=dq.peekLast();
	               dq.removeLast();
	               hm.remove(peek);
	          }
	            dq.addFirst(x);
	            hm.put(x,y);
	        }else{
	           dq.remove(x);
	           dq.addFirst(x);
	          hm.put(x,y);
	        }
	    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lru_cache l=new lru_cache(3);
		l.set(1, 10);
		l.set(2, 20);
		l.set(3, 40);
		//l.set(4, 40);
		System.out.println(dq.peekFirst());
		System.out.println(l.get(2));
		System.out.println(dq.peekFirst());
	}

}
