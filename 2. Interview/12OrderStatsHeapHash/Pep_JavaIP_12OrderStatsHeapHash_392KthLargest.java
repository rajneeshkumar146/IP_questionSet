package OrderStatsHeapHash;

import java.util.Scanner;

public class Pep_JavaIP_12OrderStatsHeapHash_392KthLargest {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int k=scn.nextInt();
		int[] arr = new int[scn.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		
		int lo=0, hi=arr.length-1;
		int index=quickselect(arr,lo,hi);
		
		while(index!=arr.length-k) {
			if(index>arr.length-k) {
				index=quickselect(arr,lo,index-1);
			}else {
				index=quickselect(arr, index+1, hi);
			}
		}
		System.out.println(arr[index]);
		
	}

	private static int quickselect( int[] arr, int lo, int hi) {
		int pivot=hi;
		
		int i=lo-1;
		int j=lo;
		while(j<pivot) {
			if(arr[j]<=arr[pivot]) {
				i++;
				swap(i,j,arr);
			}
			j++;
		}
		i++;
		swap(i,pivot,arr);
		
		
		return i;
	}

	private static void swap(int j, int pivot, int[] arr) {
		int temp=arr[j]^arr[pivot];
		arr[j]^=temp;
		arr[pivot]^=temp;
	}


}

/*
Test cases: 

3
5
1 12 13 3 5
----------------
5

3
8 
1 2 3 4 5 6 9 2
---------------
5

3
7
1 3 8 5 6 7 2
----------------
6

Source : https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
*/