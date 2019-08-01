package mystack;
import java.util.*;
public class get_minimum_from_stack {
	int minEle;
    Stack<Integer> s=new Stack<>();
    int getMin()
    {
        if(s.size() == 0)
            return -1;
	    return minEle;
    }
    int pop()
    {
        if(s.size() ==0)
            return -1;
	     int curr = s.pop();
	   
        if(curr < minEle){
            int p = minEle;
	        minEle = 2*minEle - curr;
	        return p;
	    }
	    return curr;

    }
    void push(int x)
    {
         if(s.size() == 0){
	        minEle = x;
	        s.push(x);
	    } else {
	        if(x < minEle){
	            s.push(2*x-minEle);
	            minEle = x;
	        } else {
	            s.push(x);
	        }
	    }
    }	
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
