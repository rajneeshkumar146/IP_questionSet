package reccursion;

import java.util.ArrayList;
import java.util.Arrays;

public class strobogrammatic_Number_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findStrobogrammatic(4));
	}

	public static ArrayList<String> findStrobogrammatic(int n) {
		return helper(n, n);
	}

	public static ArrayList<String> helper(int clen, int tlen) {
		if (clen == 0) {
			return new ArrayList<String>(Arrays.asList(""));
		}
		if (clen == 1) {
			return new ArrayList<>(Arrays.asList("0", "1", "8"));
		}

		ArrayList<String> rres = helper(clen - 2, tlen);
		ArrayList<String> myres = new ArrayList<>();
		for (int i = 0; i < rres.size(); i++) {
			String s = rres.get(i);
			if (clen != tlen) {
				myres.add("0" + s + "0");
			}
			myres.add("1" + s + "1");
			myres.add("6" + s + "9");
			myres.add("8" + s + "8");
			myres.add("9" + s + "6");
		}
		return myres;

	}

}
