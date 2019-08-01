package mystack;
import java.util.*;
public class del_next_smaller {

	
	public static void deletenextsmaller(int arr[],int k){
		Stack<Integer> st=new Stack<>();
	      int  i=0;
	       while(i<arr.length){
	           while(st.size()>0 && st.peek()<arr[i] && k>0){
	               st.pop();
	               k--;
	           }
	           st.push(arr[i]);
	           i++;
	       }
	    
	    
	    int res[]=new int[st.size()];
	    i=res.length-1;
	    while(st.size()>0){
	        res[i--]=st.peek();
	        st.pop();
	    }
	    for(i=0;i<res.length;i++){
	        System.out.print(res[i]+" ");
	    }
	    System.out.println();
	}
	
	public static void main(String[] args) {
		int arr[]={20 ,10 ,25 ,30 ,40};
		int k=2;
		deletenextsmaller(arr, k);
	}
}


