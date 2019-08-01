package pep_sns;

import java.util.Scanner;

public class maximum_sum_of_increasing_order_elements_from_n_arrays {

	/*
	 * 2
3 4
1 7 4 3
4 2 5 1
9 5 1 8
3 3
9 8 7
6 5 4
3 2 1
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		 int test = scn.nextInt();
		 for(int t=0; t<test; t++){
		     int n = scn.nextInt();
		     int m = scn.nextInt();
		     int[][] arr = new int[n][m];
		     for(int i=0; i<n; i++){
		         for(int j=0; j<m; j++){
		             arr[i][j] = scn.nextInt();
		         }
		     }
		     int lastrowmax = Integer.MIN_VALUE;
		     for(int i=0; i<m; i++){
		         lastrowmax = Math.max(lastrowmax, arr[n-1][i]);
		     }
		     boolean flag = false;
		     int sum = lastrowmax;
		     for(int i=n-2; i>=0; i--){
		         int currrowmax = Integer.MIN_VALUE;
		         for(int j=m-1; j>=0; j--){
		             if(arr[i][j] > currrowmax && arr[i][j] < lastrowmax){
		                 currrowmax = arr[i][j];
		             }
		         }
		         if(currrowmax == Integer.MIN_VALUE){
		             System.out.println("0");
		             flag = true;
		         }
		         sum += currrowmax;
		         lastrowmax = currrowmax;
		         if(flag == true)
		         break;
		     }
		     if(flag != true)
		     System.out.println(sum);
		 }

		 scn.close();
	}

}
