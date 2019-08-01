package SearchingSorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
/* What : Given an array print [startIndex,endIndex] of all subarrays with
* sum = 0
*HOW : Use HashMap, where key--> sum of subarray, Value: ArrayList of indices
* Put sum till i, in HashMap, if sum X occurs again at some index j,get ArrayList
* corressponding to X in HashMap, pair j+1 with all indices in ArrayList
*
* WHY :
*	If same sum occurs again , this means the elements in between have contributed
* zero sum, thus we have found one answer.
* ex : 1 4 -3 -1 1--> subarraySum([1]) = 1, subarraySum([1,4,-3,-1,1]) = 1
* therefore subarray 4,-3,-1 contributed sum = 0
*/
public class Pep_JavaIP_2SnS_66PrintAllSubarraysWith0Sum {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int[] arr = new int[scn.nextInt()];
		for (int i1 = 0; i1 < arr.length; i1++) {
			arr[i1] = scn.nextInt();
		}

		HashMap<Integer, ArrayList<Integer>> map=new HashMap<>();
		ArrayList<Integer> firstal=new ArrayList();
		firstal.add(-1);
		map.put(0, firstal);
		int sum=0;
		for(int i=0; i<arr.length; i++) {
			sum+=arr[i];
			if(map.containsKey(sum)) {
				ArrayList<Integer> al=map.get(sum);
				al.add(i);
				map.put(sum, al);
			}else {
				ArrayList<Integer> al=new ArrayList();
				al.add(i);
				map.put(sum, al);
			}

		}

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
