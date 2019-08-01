package SnS;

import java.util.Arrays;
import java.util.Scanner;

public class sort_by_absolute_difference {
	public static void main (String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int t = 0; t < test; t++) {
			int n = scn.nextInt();
			int k=scn.nextInt();
			pair[] arr = new pair[n];
			for (int i = 0; i < n; i++) {
				int val= scn.nextInt();
				int diff=Math.abs(val-k);
				arr[i]=new pair(val,diff,i);
			}
			Arrays.sort(arr);
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i].val + " ");
			}
			System.out.println();
		}
	}
	
	public static class pair implements Comparable<pair>{
	    int val;
	    int diff;
	    int idx;
	    
	    pair(int v,int d,int idx){
	        this.val=v;
	        this.diff=d;
	        this.idx=idx;
	    }
	    
	    public int compareTo(pair o){
	        if(this.diff==o.diff){
	            return this.idx-o.idx;
	        }else{
	            return this.diff-o.diff;
	        }
	    }
	}
}
