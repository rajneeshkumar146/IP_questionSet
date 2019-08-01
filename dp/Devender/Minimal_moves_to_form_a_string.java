package dp;

import java.util.Scanner;

public class Minimal_moves_to_form_a_string {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int test=scn.nextInt();
		for(int t=0;t<test;t++){
String s=scn.next();
System.out.println(vt(s));}
	}

	public static int vt(String s) {
		int[] dp = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		dp[0] = 1;
		
		StringBuilder st = new StringBuilder();
		st.append(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			st.append(s.charAt(i));
			dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
			if(2*i+2<=s.length()){
			String s2 = s.substring(i + 1, 2 * i + 2);
			if(s2.equals(st.toString())){
			dp[2 * i + 1] = Math.min(dp[i] + 1, dp[2 * i + 1]);}}
		}
           return dp[s.length()-1];
	}
}
