package mystack;
import java.util.*;
public class get_min_at_top {
	static Stack<Integer> minst=new Stack<>();    

	    public static Stack<Integer>push(int arr[],int n)
	    {
	        Stack<Integer> st=new Stack<>();
	        for(int i=0;i<n;i++){
	            if(minst.isEmpty() || minst.peek()>=arr[i])
	            minst.push(arr[i]);
	            st.push(arr[i]);
	        }
	        return st;
	    }

static void _getMinAtPop(Stack<Integer>s)
{
    while(!s.isEmpty()){
        int k=s.pop();
        if(!minst.isEmpty())
        System.out.print(minst.peek()+" ");
        if(!minst.isEmpty() && k==minst.peek())
        minst.pop();
    }
}
	    
	public static void main(String[] args) {

	}

}
