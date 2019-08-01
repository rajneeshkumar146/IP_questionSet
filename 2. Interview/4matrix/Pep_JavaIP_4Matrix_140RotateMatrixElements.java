package Matrix;

import java.util.Scanner;

public class Pep_JavaIP_4Matrix_140RotateMatrixElements {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int[][] arr=new int[scn.nextInt()][scn.nextInt()];
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				arr[i][j]=scn.nextInt();
			}
		}
		
		rotate(arr);
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static void rotate(int[][] arr) {
		int rmax=arr.length-1;
		int cmax=arr[0].length-1;
		int rmin=0;
		int cmin=0;
		int count=0;
		while(count<=arr.length*arr[0].length && rmax>=rmin && cmax>=cmin) {
			
			int col=0;
			int prev=arr[rmin][col];
			int curr=0;
			int row=0;
			row=rmin;
			for(col=cmin; col<=cmax && count<=arr.length*arr[0].length; col++) {
				curr=arr[row][col];
				arr[row][col]=prev;
				prev=curr;
				count++;
			}
			rmin++;
			
			col=cmax;
			for(row=rmin; row<=rmax && count<=arr.length*arr[0].length; row++) {
				curr=arr[row][col];
				arr[row][col]=prev;
				prev=curr;
				count++;
			}
			cmax--;
			
			row=rmax;
			for(col=cmax; col>=cmin && count<=arr.length*arr[0].length; col--) {
				curr=arr[row][col];
				arr[row][col]=prev;
				prev=curr;
				count++;
			}
			rmax--;

			col=cmin;
			for(row=rmax; row>=rmin && count<=arr.length*arr[0].length; row--) {
					curr=arr[row][col];
					arr[row][col]=prev;
					prev=curr;
					count++;
			}
			cmin++;
			arr[rmin-1][cmin-1]=prev;
		}
	}

}
/*
//clockwise rotation
4 4
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
------------------
5 1 2 3 
9 10 6 4 
13 11 7 8 
14 15 16 12 

3 3
1 2 3
4 5 6
7 8 9
--------------------
4 1 2 
7 5 3 
8 9 6 

Source: https://www.geeksforgeeks.org/rotate-matrix-elements/
*/
