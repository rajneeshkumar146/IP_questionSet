package interview.dp;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

// very similar in spirit to building bridges
public class Pep_JavaIP_7DP_206BoxStack {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		Box[] boxes = new Box[n];
		for(int i = 0; i < n; i++){
			boxes[i] = new Box(scn.nextInt(), scn.nextInt(), scn.nextInt());
		}
		
		System.out.println(solve(boxes));
	}
	
	private static class Box implements Comparable<Box>{
		int d1;
		int d2;
		int d3;
		int area;
		
		Box(int d1, int d2, int d3){
			this.d1 = d1;
			this.d2 = d2;
			this.d3 = d3;
			
			this.area = d1 * d2;
		}

		@Override
		public int compareTo(Box o) {
			return this.area - o.area;
		}
	}
	
	// Ditto same as building bridges
	// Replace non-overlapping bridges (with smaller x and y on the left) 
	// with smaller dimension bases on the top. Sorting for the same reason. 
	private static int solve(Box[] boxes){
		Box[] rotatedBoxes = new Box[3 * boxes.length];
		
		for(int i = 0; i < boxes.length; i++){
			rotatedBoxes[3 * i] = new Box(boxes[i].d1, boxes[i].d2, boxes[i].d3);
			rotatedBoxes[3 * i + 1] = new Box(boxes[i].d1, boxes[i].d3, boxes[i].d2);
			rotatedBoxes[3 * i + 2] = new Box(boxes[i].d2, boxes[i].d3, boxes[i].d1);
		}
		
		// bringing all the potentials to the left (whose min and max dimension is smaller 
		// than i's min and max) by sorting on area  
		Arrays.sort(rotatedBoxes);
		
		int[] lis = new int[rotatedBoxes.length];
		lis[0] = rotatedBoxes[0].d3;
		
		for(int i = 1; i < lis.length; i++){
			for(int j = 0; j < i; j++){
				Box batj = rotatedBoxes[j];
				Box bati = rotatedBoxes[i];
				
				if((Math.min(batj.d1, batj.d2) < Math.min(bati.d1, bati.d2)) &&
				   (Math.max(batj.d1, batj.d2) < Math.max(bati.d1, bati.d2))){
					if(lis[j] > lis[i]){
						lis[i] = lis[j];
					}
				}
			}
			
			lis[i] += rotatedBoxes[i].d3;
		}
		
		int len = 0;
		
		for(int i = 0; i < lis.length; i++){
			if(lis[i] > len){
				len = lis[i];
			}
		}
		
		return len;
	}
}

// https://www.geeksforgeeks.org/dynamic-programming-set-21-box-stacking-problem/
/* Test case 1 
4
4 6 7
1 2 3
4 5 6
10 12 32
60
*/

/* Test case 2 
5
1 2 3
2 3 5
5 4 2
3 7 1
3 6 1
14
*/
