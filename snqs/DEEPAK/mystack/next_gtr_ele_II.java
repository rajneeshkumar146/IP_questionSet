package mystack;
import java.util.*;
public class next_gtr_ele_II {
	 public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st=new Stack<>();
	            int i=0;
	            int n=nums.length;
	            int ans[]=new int[nums.length];
for(i=2*n-1;i>=0;i--){
while(!st.isEmpty() && nums[st.peek()]<=nums[i%n]){
	st.pop();
}
ans[i%n]=st.size()==0?-1:nums[st.peek()];
st.push(i%n);
}
	           
	        return ans;
	    }
	public static void main(String[] args) {
int arr[]={1,2,1};
int res[]=nextGreaterElements(arr);
for(int v:res){
	System.out.print(v+" ");
	
}

	}

}
