package InternQuestAS1;

import java.util.Scanner;

public class Remove_Element {
	 public static  int removeElement(int[] nums, int val) {
		 int count=0;
		 int j=0;
		 for(int i=0;i<nums.length;i++){
			 if(nums[i]==val){
				 count++;
			 }
			 if(nums[i]!=val){
				 nums[j]=nums[i];
				 j++;
			 }
		 }
		 
		return nums.length-count;
		 
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int []nums = {0,1,2,2,3,0,4,2};
		int val = 2;
		System.out.println(removeElement(nums, val));
		
		

	}

}
