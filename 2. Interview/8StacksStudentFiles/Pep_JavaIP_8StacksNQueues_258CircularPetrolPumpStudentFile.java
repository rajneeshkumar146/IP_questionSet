--------------------------------------------------------------------------------
Description
--------------------------------------------------------------------------------
1. You are given an integer n, which represents number of petrol pumps on a circular road.
2. You are given two sets of data.
   i. The amount of petrol that a petrol pump has.
   ii. Distance from that petrol pump to the next petrol pump.
3. The truck will stop at each petrol pump and it has infinite capacity.
4. For 1 litre petrol, the truck can go 1 unit of distance.
5. Calculate the first point from where a truck will be able to complete the circle.
   Target Complexity : O(n)
--------------------------------------------------------------------------------
--------------------------------------------------------------------------------
package Stacks;

import java.util.Scanner;

public class Pep_JavaIP_8StacksNQueues_258CircularPetrolPump {

	static class petrolPump {
		int petrol;
		int distance;

		// constructor
		public petrolPump(int petrol, int distance) {
			this.petrol = petrol;
			this.distance = distance;
		}
	}

	// The function returns starting point if there is a possible solution,
	// otherwise returns -1
	static int printTour(petrolPump arr[], int n) {
	
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);

		petrolPump[] arr = new petrolPump[scn.nextInt()];
		for(int i=0; i<arr.length; i++){
			arr[i]=new petrolPump(scn.nextInt(), scn.nextInt());
		}

		int start = printTour(arr, arr.length);

		System.out.println(start == -1 ? "No Solution" : start);

	}
}

/*Test Cases:
3
6 4
3 6
7 3
---------------
2

4
4 6
6 5
7 3
4 5
------------------
1


34
78 87 94 16 87 36 50 93 63 22 91 28 64 60 41 27 73 27 12 37 68 69 83 30 63 31 68 24 30 36 23 3 70 59 94 68 12 57 30 43 22 74 85 20 99 38 16 25 14 71 92 27 57 81 63 74 97 71 6 82 85 26 37 28 47 6 14 30
--------------------
1


4
4 6
3 5
3 3
4 5
------------------
No Solution

Source: https://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/

*/
