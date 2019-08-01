package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Fact_Digit_Sum {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] fact = new int[10];
		fact[0] = 1;
		fact[1] = 1;
		for (int i = 2; i <= 9; i++) {
			fact[i] = fact[i - 1] * i;
		}
		for (int z = 0; z < t; z++) {
			int x = Integer.parseInt(br.readLine());
			ArrayList<Integer> list = new ArrayList<>();
			digitsum(x, fact, list, 9);
			for (int i = list.size() - 1; i >= 0; i--) {
				System.out.print(list.get(i));
			}
			System.out.println();
		}
	}

	private static void digitsum(int x, int[] fact, ArrayList<Integer> list, int cnum) {
		if (x == 0) {
			return;
		}
		if (fact[cnum] > x) {
			cnum--;
			digitsum(x, fact, list, cnum);
		} else {
			x = x - fact[cnum];
			list.add(cnum);
			digitsum(x, fact, list, cnum);
		}
	}
}
