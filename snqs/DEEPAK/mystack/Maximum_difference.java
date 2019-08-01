package mystack;
import java.util.*;
public class Maximum_difference {
	public static int[] findleftsmall(int[] arr){
	    Stack<Integer> st=new Stack<>();
	    int ans[]=new int[arr.length];
	    int i=arr.length-1;
	    while(i>=0){
	        while(!st.isEmpty() && arr[st.peek()]>arr[i]){
	            ans[st.pop()]=arr[i];
	        }
	        st.push(i);
	        i--;
	    }
	    return ans;
	}
	
	public static int[] findrightsmall(int[] arr){
		Stack<Integer> st=new Stack<>();
		int[] ans=new int[arr.length];
		int i=0;
		while(i<arr.length){
			while(!st.isEmpty() && arr[st.peek()]>arr[i]){
				ans[st.pop()]=arr[i];
			}
			st.push(i);
			i++;
		}
		return ans;
	}
	public static void main(String[] args) {
int arr[]={2 ,1 ,8
};
int arr2[]={5,2,6,1,2};
int[] leftsmaller=findleftsmall(arr2);
for(int v:leftsmaller){
	System.out.print(v+" ");
}
System.out.println();
int[] rightsmaller=findrightsmall(arr2);
for(int v:rightsmaller){
	System.out.print(v+" ");
}
System.out.println();
int max=Integer.MIN_VALUE;
for(int i=0;i<arr.length;i++){
max=Math.max(Math.abs(leftsmaller[i]-rightsmaller[i]), max);
}
System.out.println(max);
	}

}
