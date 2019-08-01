package OrderStatsHeapHash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_12OrderStatsHeapHash_418FourElements {
	
	//given an array of distinct integers,
	// we just have to print one occurence of such 4 elements a,b,c,d, such that a+b=c+d
	
	static class Pair{
		int fp;
		int sp;
		
		public Pair(int fp, int sp) {
			this.fp=fp;
			this.sp=sp;
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		//the array is of distinct integers
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		
		HashMap<Integer, Pair> map=new HashMap<>();
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				//this will generate all possible pairs
				int sum=arr[i]+arr[j];
				if(map.containsKey(sum)) {
					Pair pair=map.get(sum);
					System.out.println("("+arr[pair.fp]+" "+arr[pair.sp]+")");
					System.out.println("("+arr[i]+" "+arr[j]+")");
					return;
				}else {
					Pair pair=new Pair(i, j);
					map.put(sum, pair);
				}
				
			}
		}

	}

}
/*
Test cases:
	7
	1 2 3 4 7 9 8
	-------------------
	(1 4)
	(2 3)
	
	
	7
	3 4 7 1 2 9 8 
	------------------
	(3 8)
	(4 7)
	
	
	4
	1 2 3 4
	--------------
	(1 4)
	(2 3)
	
	Source: https://www.geeksforgeeks.org/find-four-elements-a-b-c-and-d-in-an-array-such-that-ab-cd/
	
	*/
