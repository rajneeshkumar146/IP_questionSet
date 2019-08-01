package SnS;

import java.util.Scanner;

public class value_Equal_to_Index_value {
	public static void main (String[] args) {
		Scanner scn=new Scanner(System.in);
		int tc=scn.nextInt();
		for(int i=0;i<tc;i++){
		    int n=scn.nextInt();
		    int[] arr=new int[n];
		    for(int k=0;k<n;k++){
		        arr[k]=scn.nextInt();
		    }
		    ValueEqualToIndex(arr);
		}
	}
	public static void ValueEqualToIndex(int[] arr){
	    boolean flag=false;
	    for(int i=0;i<arr.length;i++){
	        if(arr[i]==i+1){
	            flag=true;
                System.out.print(i+1+" ");	            
	        }
	    }
	    if(!flag){
	        System.out.println("Not Found");
	    }
	    else{
	        System.out.println(); 
	    }
	}
}
