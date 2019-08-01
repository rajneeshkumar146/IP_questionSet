package interview.greedy;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
*Let creditors be above the axis and debtors below it. For cashflow to complete
* both have to come to axis. We have to minimize the number of operations to do
*so.Where distance from axis is amount of money required.
* given that : c1 + c2 + c3 + d1 + d2 + d3 = 0
*   C1                     C3
*   |       C2             |
*   |       |              |
*   |       |              |
*   |       |              |
*   |       |              |        Total = + 13K
*----------------------------------------------------------axis
* |           |                  |   Total = - 13K
* D1          |                  |
*             |                  |
*             |                  |
*             |                  |
*             D2                 |
*                                D3
*
* This code essentially finds minimum number of operations to move all points to
* axis.
* Greedy : // settle highest debts with highest creditor at each iteration
*/
public class Pep_JavaIP_6Greedy_190MinimizeCashFlow {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[][] mat = new int[n][n];
		for(int i = 0; i < mat.length; i++){
			for(int j = 0; j < mat.length; j++){
				mat[i][j] = scn.nextInt();
			}
		}

		int res = solve(mat);
		System.out.println(res);
	}

	private static int solve(int[][] mat){
		int[] net = new int[mat.length];
		for(int i = 0; i < mat.length; i++){
			for(int j = 0; j < mat[i].length; j++){
				net[i] -= mat[i][j];
				net[j] += mat[i][j];
			}
		}
		// settle highest debt and credit at each iteration
		PriorityQueue<Integer> debtors = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> creditors = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i < net.length; i++){
			if(net[i] < 0){
				debtors.add(-net[i]);
			} else {
				creditors.add(net[i]);
			}
		}

		int sum = 0;
		// settle highest debts with highest creditor at each iteration
		while(debtors.size() > 0 && creditors.size() > 0){
			int highestDebt = debtors.remove();
			int highestCredit = creditors.remove();

			if(highestDebt > highestCredit){
				sum += highestCredit;
				debtors.add(highestDebt - highestCredit);
			} else {
				sum += highestDebt;
				creditors.add(highestCredit - highestDebt);
			}
		}

		return sum;
	}

}
/*
Test cases:

*************************************************
test case 1
*************************************************
3 
0 1000 2000
0 0 5000
0 0 0
---------------
7000

*************************************************
test case 2
*************************************************
5
0 0 0 0 0
0 0 0 0 0
0 700 0 0 0
500 0 0 0 0
500 0 0 0 0
------------------
1700


*************************************************
test case 3
*************************************************
5
0 0 0 0 0
0 0 0 0 0
0 700 0 0 0
500 0 0 0 0
700 0 0 0 0
------------------
1900

*/

