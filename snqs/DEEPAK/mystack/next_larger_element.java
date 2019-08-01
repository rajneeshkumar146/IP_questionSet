package mystack;
import java.util.*;
public class next_larger_element {
    public  static int[] nextLargerEle(int[] arr) {
    Stack<Integer> st=new Stack<>();
    int i=0;
    int res[]=new int[arr.length];
    while(i<arr.length){
	       while(!st.isEmpty() && arr[st.peek()]<arr[i]){
	           res[st.pop()]=arr[i];
	       }
	       st.push(i);
	       i++;
    }
    for(int j=0;j<res.length;j++){
        if(res[j]==0)
        res[j]=-1;
    }
	       
	        return res;
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int arr[]={1,3,2,5};
int res[]=nextLargerEle(arr);
for(int v:res){
	System.out.println(v);
}

	}

}
