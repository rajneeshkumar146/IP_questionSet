package interview.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Pep_JavaIP_5Backtracking_164CryptoArithmetic {
	static String exp1;
	static String exp2;
	static String exp3;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		exp1 = scn.nextLine();
		exp2 = scn.nextLine();
		exp3 = scn.nextLine();

		HashMap<Character, Integer> ques = new HashMap<>();
		populateQMap(ques, exp1);
		populateQMap(ques, exp2);
		populateQMap(ques, exp3);

		HashSet<Integer> availNums = new HashSet<>();
		for (int i = 0; i <= 9; i++) {
			availNums.add(i);
		}

		HashMap<Character, Integer> ans = new HashMap<>();
		solve(ques, ans, availNums);
	}

	static int counter = 0;
	public static void solve(HashMap<Character, Integer> ques, 
							 HashMap<Character, Integer> ans, 
							 HashSet<Integer> nums) {
		if(ques.size() == 0){
			if(IsValid(ans)){
				System.out.println(ans);
			}
			return;
		}
		Character ch = ques.keySet().iterator().next();
		ques.remove(ch);
		
		ArrayList<Integer> availNums = new ArrayList<>(nums);
		for(int num: availNums){
			ans.put(ch, num);
			nums.remove(num);
			
			solve(ques, ans, nums);
			
			ans.remove(ch);
			nums.add(num);
		}
		
		ques.put(ch, null);
	}

	private static boolean IsValid(HashMap<Character, Integer> ans) {
		int num1 = getNum(exp1, ans);
		int num2 = getNum(exp2, ans);
		int num3 = getNum(exp3, ans);

		return num1 + num2 == num3;
	}

	private static int getNum(String exp, HashMap<Character, Integer> ans) {
		int num = 0;

		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(exp.length() - 1 - i);
			num += ans.get(ch) * Math.pow(10, i);
		}

		return num;
	}
	
	private static void populateQMap(HashMap<Character, Integer> ques, String exp){
		for (int i = 0; i < exp.length(); i++) {
			ques.put(exp.charAt(i), null);
		}
	}
}
