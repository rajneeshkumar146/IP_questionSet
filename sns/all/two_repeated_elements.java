package SnS;

import java.util.Scanner;

public class two_repeated_elements {

	public static void main (String[] args) {
		Scanner scn = new Scanner(System.in);
		int tc = scn.nextInt();
		for (int j = 0; j < tc; j++) {
			int n = scn.nextInt();
			int[] arr=new int[n+2];
			for(int i=0;i<n+2;i++){
			    arr[i]=scn.nextInt();
			}
			repeatingNumber(arr,n);
		}
	}
	
	public static void repeatingNumber(int[] arr,int n){
	    int[] countArr=new int[n+1];
	    for(int i=0;i<arr.length;i++){
	        if(countArr[arr[i]]!=0){
	            System.out.print(arr[i]+" ");
	        }
	        countArr[arr[i]]=1;
	    }
	    System.out.println();
	}
//	
//	public static void repeatingNumber2(int[] arr,int n){
//	    int xor=arr[0];
//	    int mask=0;
//	    int x=0,y=0;
//	    for(int i=1;i<arr.length;i++){
//	        xor^=arr[i];
//	    }
//	    for(int i=1;i<=n;i++){
//	        xor^=i;
//	    }
//	}
}
