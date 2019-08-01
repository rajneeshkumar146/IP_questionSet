package SnS;

import java.util.Scanner;

public class smallest_factorial_number {

	public static void main (String[] args) {
		Scanner scn=new Scanner(System.in);
		int test=scn.nextInt();
		for(int t=0;t<test;t++){
		    int n=scn.nextInt();
		    int res=findSmallestFactorial(n);
		    System.out.println(res);
		}
	}
	
	public static boolean checkNumber(int val,int n){
	    int temp=5;
	    int count=0;
	    while(temp<=val){
	       count+=Math.floor(val/temp);
	       temp=temp*5; 
	    }
	    
	    return  count>=n;
	    
	}
	
	public static int findSmallestFactorial(int n){
	    if(n==1){
	        return 5;
	    }
	    
	    int low=0;
	    int high=5*n;
	    
	    while(low<high){
	        int mid=(low+high)/2;   
	        if(checkNumber(mid,n)){
	            high=mid;
	        }else{
	            low=mid+1;
	        }
	        
	    }   
	    return low;
	}
}
