package InternQuestDP;

import java.util.Scanner;

public class Reach_a_given_score {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		while(t-->0){
		int n=scn.nextInt();
		int totalcomb=combinations(n);
		System.out.println(totalcomb);
		
		}
	}

	private static int combinations(int n) {
		int[] score ={3,5,10};
		int[] strg= new int[n+1];
		strg[0]=1;
		for(int i=0;i<score.length;i++){
			for(int j=0;j<strg.length;j++){
				if(j-score[i]>=0){
					strg[j]=strg[j]+strg[j-score[i]];
				}
			}
		}
		
		return strg[n];
	}

}
