xz package mystack;
import java.util.*;
public class freq_stack {
	 static Map<Integer, Integer> freq;
	 static   Map<Integer, Stack<Integer>> grp;
	   static int mfreq;

	    public  freq_stack() {
	        freq = new HashMap();
	        grp = new HashMap();
	        mfreq = 0;
	    }

	    public static void push(int x) {
	        int f = freq.getOrDefault(x, 0)+1;
	        freq.put(x, f);
	        if (f > mfreq)
	            mfreq = f;

	        grp.computeIfAbsent(f, z-> new Stack()).push(x);
	    }

	    
	    
	    
	    public static int pop() {
	    	
	        int top = grp.get(mfreq).pop();
	        freq.put(top, freq.get(top) - 1);
	        if (grp.get(mfreq).size() == 0)
	            mfreq--;
	        return top;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		freq_stack f=new freq_stack();
push(5);
push(5);
push(7);
System.out.println(pop());
pop();
	}

}
