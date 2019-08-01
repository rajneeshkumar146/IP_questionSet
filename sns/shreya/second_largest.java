package SnS;

import java.util.Scanner;

public class second_largest {


	public static void main (String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int t = 0; t < test; t++) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}
			int largest=Integer.MIN_VALUE;
			int sl=Integer.MIN_VALUE;
    		for(int i=0;i<arr.length;i++){
    		    if(arr[i]>largest){
    		        sl=largest;
    		        largest=arr[i];
    		    }else if(arr[i]<largest){
    		        if(sl<arr[i])
    		            sl=arr[i];
    		    }
    		}
		System.out.println(sl);
		}
	}
}
