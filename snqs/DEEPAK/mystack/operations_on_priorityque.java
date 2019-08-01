package mystack;
import java.util.*;
public class operations_on_priorityque {
	static void insert(PriorityQueue<Integer> q, int k){
        
		q.add(k);
		    }
	 static boolean find(PriorityQueue<Integer> q, int k){
	        if(q.contains(k))
	        return true;
	        else
	        return false;
	        
	    }
	 static int delete(PriorityQueue<Integer> q){
	        int peek=Collections.max(q);

	        q.remove(peek);
	        return peek;
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> pq=new PriorityQueue();
		insert(pq, 333);

insert(pq, 3);
insert(pq, 13);
insert(pq, 33);
insert(pq, 43);
System.out.println(find(pq, 3));
System.out.println(delete(pq));
System.out.println(delete(pq));


	}

}
