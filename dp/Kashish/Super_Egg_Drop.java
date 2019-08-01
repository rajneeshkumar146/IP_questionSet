package InternQuestDP;

import java.util.Scanner;

public class Super_Egg_Drop {
	static int minimum_trials(int egg,int floors){
		int[][] strg=new int[egg+1][floors+1];
		for(int i=1;i<strg.length;i++){
			for(int j=0;j<strg[0].length;j++){
				if(i==1){
					strg[i][j]=j;
				}
				else if(j==1){
					strg[i][j]=1;
				}
				else if(j==0){
					strg[i][j]=0;
				}
				else{
					strg[i][j]=Integer.MAX_VALUE;
					for(int op=1;op<=j;op++){
						int br=strg[i-1][op-1];
						int sur=strg[i][j-op];
						strg[i][j]=Math.min(strg[i][j], Math.max(br, sur)+1);
					}
				}
			}
		}
		return strg[egg][floors];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int eggs=scn.nextInt();
		int floors=scn.nextInt();
		System.out.println(minimum_trials(eggs, floors));

	}

}
