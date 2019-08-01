package SnS;

import java.util.Arrays;

public class Wiggle_sort_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {1, 5, 1, 1, 6, 4};
		wiggleSort(nums);
		for(int i=0;i<nums.length;i++) {
			System.out.print(nums[i]+" ");
		}
		System.out.println(".");
	}
	public static void wiggleSort(int[] nums) {
        if(nums==null||nums.length==0){
            return;
        }
        Arrays.sort(nums);
        int[] temp=new int[nums.length];
        int mid,lhalf,rhalf;
        
        mid=nums.length%2==0?(nums.length/2)-1:(nums.length/2);
        lhalf=mid;
        rhalf=nums.length-1;
        
        for(int i=0;i<temp.length;i++){
            if(i%2==0){
                temp[i]=nums[lhalf];
                lhalf--;
            }else{
                temp[i]=nums[rhalf];
                rhalf--;
            }
        }
        
        for(int i=0;i<nums.length;i++){
            nums[i]=temp[i];
        }
    }
}
