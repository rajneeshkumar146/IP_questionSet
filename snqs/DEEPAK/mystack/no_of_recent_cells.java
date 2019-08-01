package mystack;
import java.util.*;
public class no_of_recent_cells {
	Queue<Integer> q;
    public no_of_recent_cells() {
        q=new LinkedList<>();
    }
    
    public int ping(int t) {
       q.add(t);
        while(q.peek()<t-3000){
            q.remove();
        }
        return q.size();
    }
	public static void main(String[] args) {
		no_of_recent_cells n=new no_of_recent_cells();
		System.out.println(n.ping(1));
		System.out.println(n.ping(100));
		System.out.println(n.ping(3001));
		System.out.println(n.ping(3002));
		//System.out.println();
		
		
		
	}

}
