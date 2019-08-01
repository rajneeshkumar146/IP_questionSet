package interview.graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Pep_JavaIP_12Agraphs_426HackerEarthMancunian {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[Integer.parseInt(scn.nextLine())];
		for (int i = 0; i < arr.length - 1; i++) {
			arr[i] = Integer.parseInt(scn.next());
		}

		int[] regular = countVisitableElements(arr, 0);
		int[] reversed = countVisitableElements(arr, 1);

		int toggled = 0;
		int ops = scn.nextInt();
		for (int i = 0; i < ops; i++) {
			char op = scn.next().charAt(0);
			if (op == 'U') {
				toggled = Math.abs(toggled - 1);
			} else {
				int vtx = Integer.parseInt(scn.next());
				vtx = vtx - 1;
				System.out.println(toggled == 0 ? regular[vtx] : reversed[vtx]);
			}
		}
	}
	
	private static int[] countVisitableElements(int[] arr, int toggle){
		int[] result = new int[arr.length];
		
		int[] visitableToLeft = new int[arr.length];
		for(int i = 0; i <= visitableToLeft.length - 2; i++){
			if(arr[i] == Math.abs(0 - toggle)){
				visitableToLeft[i + 1] += visitableToLeft[i] + 1;
			}
		}
		
		int[] visitableToRight = new int[arr.length];
		for(int i = visitableToRight.length - 1; i >= 1; i--){
			if(arr[i - 1] == Math.abs(1 - toggle)){
				visitableToRight[i - 1] += visitableToRight[i] + 1;
			}
		}
		
		for(int i = 0; i < result.length; i++){
			result[i] = visitableToLeft[i] + visitableToRight[i] + 1;
		}
		
		return result;
	}

}
