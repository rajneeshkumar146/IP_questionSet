-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
                                       Question Description
-----------------------------------------------------------------------------------------
1. You are given an array of n integers.
2. You have to find all the sub-arrays of given array,
   whose sum of elements is equal to 0.
3. Print starting and end indices of all such sub-arrays.	 
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
package SearchingSorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_2SnS_66PrintAllSubarraysWith0Sum {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int[] arr = new int[scn.nextInt()];
		for (int i1 = 0; i1 < arr.length; i1++) {
			arr[i1] = scn.nextInt();
		}

		HashMap<Integer, ArrayList<Integer>> map=new HashMap<>();


	   //code to find all sub-arrays with 0





		ArrayList<Integer> al=new ArrayList<>(map.keySet());
		Collections.sort(al);
		for(int key: al) {
			ArrayList<Integer> getal=map.get(key);
			//print all the pairs
			for(int i=0; i<getal.size(); i++) {
				for(int j=i+1; j<getal.size(); j++) {
					System.out.println(getal.get(i)+1+" "+ getal.get(j));
				}
			}
		}

	}

}
/*
Test cases
11
6 3 -1 -3 4 -2 2 4 6 -12 -7
--------------
0 10
6 9
2 4
2 6
5 6

5
13 14 -15 17 -16
------------------
1 4


10
1 2 3 -4 -5 6 7 8 9 10
-------------------------
2 5

Source:https://www.geeksforgeeks.org/print-all-subarrays-with-0-sum/

*/
