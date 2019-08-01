package interview.binaryTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_10BST_388PrintLeavesFromPreorder {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		
		solve(arr);
	}
	
	private static void solve(int[] preo){
		int[] ino = Arrays.copyOf(preo, preo.length);
		Arrays.sort(ino);

		printleaves(preo, ino, 0, preo.length - 1, 0, ino.length - 1);
	}
	
	private static void printleaves(int[] preo, int[] ino, int psi, int pli, int isi, int ili){
		if(isi > ili || psi > pli){
			return;
		}
		
		if(isi == ili){
			System.out.print(ino[isi] + " ");
			return;
		}
		
		int idx = Arrays.binarySearch(ino, preo[psi]);
		int left = idx - isi;
		
		printleaves(preo, ino, psi + 1, psi + left, isi, idx - 1);
		printleaves(preo, ino, psi + left + 1, pli, idx + 1, ili);
	}
	
}

// https://www.geeksforgeeks.org/find-median-bst-time-o1-space/
/*Test Case 1
7
50 25 12 37 75 62 87
12 37 62 87 
*/

/*Test Case 2
10
50 20 10 30 25 35 70 60 55 80
10 25 35 55 80 
*/

/*Test Case 3
10
50 20 10 30 25 36 70 60 55 80
10 25 36 55 80 
*/