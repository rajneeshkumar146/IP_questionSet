package SnS;

import java.util.Arrays;
import java.util.Scanner;

public class sort_the_given_array_by_equation {
	
	public static void main (String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int t = 0; t < test; t++) {
		    int A=scn.nextInt();
		    int B=scn.nextInt();
		    int C=scn.nextInt();
			int n = scn.nextInt();
			long[] arr = new long[n];
			for (int j = 0; j < n; j++) {
				arr[j] = scn.nextLong();
			}
			
			sortByEquation(arr,A,B,C);
		}
		
	}
	
	public static void sortByEquation(long[] arr,int a,int b,int c){
			    
	    for(int i=0;i<arr.length;i++){
	        arr[i]=(a*arr[i]*arr[i])+(b*arr[i])+c;
	    }
	   Arrays.sort(arr);
	    for(int i=0;i<arr.length;i++){
	        System.out.print(arr[i]+" ");
	    }
	    System.out.println();
	}

}
