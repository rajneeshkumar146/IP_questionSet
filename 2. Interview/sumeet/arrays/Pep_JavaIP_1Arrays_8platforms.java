package interview.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Pep_JavaIP_1Arrays_8platforms {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		
		int[] arrivals = new int[n];
		int[] departures = new int[n];
		
		for(int i = 0; i < arrivals.length; i++) {
			arrivals[i] = scn.nextInt();
		}
		
		for(int i = 0; i < departures.length; i++) {
			departures[i] = scn.nextInt();
		}
		
		solve(arrivals, departures);
	}

	private static void solve(int[] arrivals, int[] departures) {
		Arrays.sort(arrivals);
		Arrays.sort(departures);
		
		int i = 0;
		int j = 0;
		int count = 0;
		int max = Integer.MIN_VALUE;
		
		while(i < arrivals.length && j < departures.length) {
			if(arrivals[i] < departures[j]) {
				count++;
				i++;
			} else {
				count--;
				j++;
			}
			
			if(count > max) {
				max = count;
			}
		}
		
		System.out.println(max);
	}

}
