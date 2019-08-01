package SnS;

import java.util.Arrays;
import java.util.Scanner;

public class sort_by_bit_count {
	public static void main (String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int t = 0; t < test; t++) {
			int n = scn.nextInt();
			pair[] arr = new pair[n];
			for (int i = 0; i < n; i++) {
				int val= scn.nextInt();
				int count=countSetBits(val);
				arr[i]=new pair(val,count,i);
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
	    int count;
	    int idx;
	    
	    pair(int v,int c,int idx){
	        this.val=v;
	        this.count=c;
	        this.idx=idx;
	    }
	    
	    public int compareTo(pair o){
	        if(this.count==o.count){
	            return this.idx-o.idx;
	        }else{
	            return o.count-this.count;
	        }
	    }
	}
	
	public static int countSetBits(int val){
	    int i=0;
	    int count=0;
	    while((1<<i)<=val){
	        if((val&(1<<i))==(1<<i)){
	            count++;
	        }
	       i++;
	    }
	    return count;
	}

}
