package mystack;
import java.util.*;
public class next_gtr_ele_1 {
	 public int[] nextGreaterElement(int[] nums1, int[] nums2) {
	      Stack<Integer> st=new Stack<>();
	        HashMap<Integer,Integer> map=new HashMap<>();
	        int i=0;
	        while(i<nums2.length){
	            while(!st.isEmpty() && st.peek()<nums2[i]){
	                map.put(st.pop(), nums2[i]);
	            }
	            st.push(nums2[i]);
	            i++;
	        }
	        int ans[]=new int[nums1.length];
	        for( i=0;i<nums1.length;i++){
	        	ans[i]=map.getOrDefault(nums1[i],-1);
	        }
	        return ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
