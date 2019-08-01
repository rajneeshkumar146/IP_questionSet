package SnS;

import java.util.Arrays;

public class wiggle_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,3,5,2,4,6};
		wiggleSort(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}

	 public static  void wiggleSort(int[] nums) {
	        if(nums.length<=1){
	            return;
	        }
	        Arrays.sort(nums);
	        for(int i=1;i<nums.length-1;i+=2){
	            int temp=nums[i];
	            nums[i]=nums[i+1];
	            nums[i+1]=temp;
	        }
	    }
}
