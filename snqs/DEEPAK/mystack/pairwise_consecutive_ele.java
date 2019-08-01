package mystack;
import java.util.*;
public class pairwise_consecutive_ele {
	 public static boolean pairWiseConsecutive(Stack<Integer> st)
	    {
	 while(st.size() != 0){
	   if(st.size() == 1){
	    return true;
	}

	int a=Math.abs(st.pop());
	int b=Math.abs(st.pop());
	if(Math.abs(a-b)==1){
	    continue;
	}else
	return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
