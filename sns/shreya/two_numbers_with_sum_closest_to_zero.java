package SnS;

import java.util.Arrays;
import java.util.Scanner;

public class two_numbers_with_sum_closest_to_zero {

	public static void main (String[] args) {
		Scanner scn = new Scanner(System.in);
		int tc = scn.nextInt();
		for (int j = 0; j < tc; j++) {
			int n = scn.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++){
			    arr[i]=scn.nextInt();
			}
			closestSum(arr);
		}
	}
	
	public static void closestSum(int[] arr){
	    int left=0,right=arr.length-1;
	    int curSum=0;
	    int minSum=Integer.MAX_VALUE;
	    Arrays.sort(arr);
	    
	    while(left<right){
	        curSum=arr[left]+arr[right];
	        
	        if(Math.abs(curSum)<Math.abs(minSum)){
	            minSum=curSum;
	        }
	        
	        if(curSum<0){
	            left++;
	        }else{
	            right--;
	        }
	        
	    }
	    
	    System.out.println(minSum);
	}
	

}
