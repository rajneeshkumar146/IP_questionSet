--------------------------------------------------------------------------------
Description
--------------------------------------------------------------------------------
1. You are given a matrix of dimension m*n where each cell in the matrix can have values 0, 1 or 2
   which has the following meaning:
   0: Empty cell
   1: Cells have fresh oranges
   2: Cells have rotten oranges
2. You have to find the minimum time required so that all the oranges become rotten.
3. A rotten orange at index [i,j] can rot other fresh orange
   at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in one unit of time.
4. Print -1 if it is not possible to make all oranges rotten.
--------------------------------------------------------------------------------
--------------------------------------------------------------------------------
package Stacks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Pep_JavaIP_8StacksNQueues_259RottenOranges {


	// structure for storing coordinates of the cell
	static class Ele {
		int x = 0;
		int y = 0;

		Ele(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	// function to check whether a cell is valid / invalid
	static boolean isValid(int i, int j, int[][] arr) {
		
	}

	// Function to check whether the cell is delimiter
	// which is (-1, -1)
	static boolean isDelim(Ele temp) {

	}

	// Function to check whether there is still a fresh
	// orange remaining
	static boolean checkAll(int arr[][]) {

	}

	// This function finds if it is possible to rot all oranges or not.
	// If possible, then it returns minimum time required to rot all,
	// otherwise returns -1
	static int rotOranges(int arr[][]) {


	}

	// Drive program
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int R = scn.nextInt();
		int C = scn.nextInt();
		int[][] mat = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				mat[i][j] = scn.nextInt();
			}
		}

		int ans = rotOranges(mat);
		if (ans == -1)
			System.out.println("Not Possible");
		else
			System.out.println(ans);
	}

}


/*
 *
3 5
2 1 0 0 2
1 1 1 0 1
1 1 1 2 1
--------------------------
2

3 5
2 1 0 0 2
1 0 1 0 1
1 1 0 2 1
-------------------
Not Possible


4 5
2 1 0 0 2
1 1 1 0 1
1 1 0 2 1
2 1 1 0 1
-------------------
3

Source: https://www.geeksforgeeks.org/minimum-time-required-so-that-all-oranges-become-rotten/

*/
