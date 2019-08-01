package SnS;

import java.util.Scanner;

public class stable_sort_and_position {

	public static void main (String[] args) {
		Scanner scn=new Scanner(System.in);
		int test=scn.nextInt();
		for(int i=0;i<test;i++){
		    int n=scn.nextInt();
		    int idx=scn.nextInt();
		    int[] arr=new int[n];
		    for(int j=0;j<n;j++){
		        arr[j]=scn.nextInt();
		    }
		    
		    int count=0;
		    for(int j=0;j<n;j++){
		        if(arr[j]<arr[idx]){
		            count++;
		        }
		        if(arr[j]==arr[idx]&&j<idx){
		            count++;
		        }
		        
		    }
		    System.out.println(count);
		}
	}
}
