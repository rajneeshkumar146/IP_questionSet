package InternQuestDP;

import java.util.Scanner;

public class Push_Dominoes {
	public static String pushDominoes(String dominoes) {
		char[] chars = dominoes.toCharArray();
		int val = chars.length;
		int force = 0;
		int[] forces = new int[chars.length];
		for (int i = 0; i < chars.length; i++) {

			if (chars[i] == 'R') {
				force = val;
				forces[i] = val;
			} else if (chars[i] == 'L') {
				force = 0;
				forces[i] = 0;
			} else {
				if (force != 0) {
					--force;
					forces[i] = force;
				}
			}
		}
		for (int i = chars.length - 1; i >= 0; i--) {

			if (chars[i] == 'L') {
				force = val;
				forces[i] -= force;
			} else if (chars[i] == 'R') {
				force = 0;
			} else {
				if (force != 0) {
					--force;
					forces[i] -= force;
				}
			}
			
		}
		String ans ="";
		for(int f:forces){
			if(f>0){
				ans+="R";
			}
			else if(f<0){
				ans+="L";
			}
			else{
				ans+=".";
			}
		}
		
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String dominoes = scn.next();
		String standingdomino = pushDominoes(dominoes);
		System.out.println(standingdomino);

	}

}
