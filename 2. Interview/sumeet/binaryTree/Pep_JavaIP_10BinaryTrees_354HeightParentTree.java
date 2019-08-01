package interview.binaryTree;

import java.util.HashMap;
import java.util.Scanner;

import javax.print.DocFlavor.CHAR_ARRAY;

public class Pep_JavaIP_10BinaryTrees_354HeightParentTree {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] parr = new int[scn.nextInt()];
		for (int i = 0; i < parr.length; i++) {
			parr[i] = scn.nextInt();
		}

		int height = solve(parr);
		System.out.println(height);
	}

	private static int solve(int[] parr) {
		int max = Integer.MIN_VALUE;
		
		int[] harr = new int[parr.length];
		for (int i = 0; i < harr.length; i++) {
			if (parr[i] != -1 && harr[i] == 0) {
				harr[i] = getLevel(parr, harr, parr[i]) + 1;
			}
			
			if(harr[i] > max){
				max = harr[i];
			}
		}
		
		return max;
	}

	private static int getLevel(int[] parr, int[] harr, int i) {
		if(parr[i] == -1){
			return 0; // its the root
		} else if(harr[i] != 0){
			return harr[i]; // already calculated
		} else {
			harr[i] = 1 + getLevel(parr, harr, parr[i]); // calculate
			return harr[i];
		}
	}
}
// https://www.geeksforgeeks.org/find-height-binary-tree-represented-parent-array/
/* Test Case 1
7
1 5 5 2 2 -1 3
3
*/

/* Test Case 2
8
5 -1 1 1 2 3 4 4
3
*/
