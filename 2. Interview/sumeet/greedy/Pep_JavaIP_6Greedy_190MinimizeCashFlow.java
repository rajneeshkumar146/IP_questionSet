package interview.greedy;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

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
