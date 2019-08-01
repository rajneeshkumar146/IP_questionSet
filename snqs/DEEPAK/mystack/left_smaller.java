package mystack;
import java.util.*;
public class left_smaller {
	 public static int[] leftsmall(int arr[]){
	        Stack<Integer> st=new Stack<>();
	        int res[]=new int[arr.length];
	        Arrays.fill(res,-1);
	        int i=arr.length-1;
	        while(i>=0){
	            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
	                res[st.pop()]=arr[i];
	            }
	            st.push(i);
	            i--;
	        }
	        return res;
	    }
	 public static void main(String[] args){
		int arr[]={4,7,3,7,1,5};
		int res[]=leftsmall(arr);
		for(int v:res){
			System.out.print(v+" ");
		}
	 }
}
